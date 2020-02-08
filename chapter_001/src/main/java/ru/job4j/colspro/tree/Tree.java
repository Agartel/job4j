package ru.job4j.colspro.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree, Iterable {
    private Node<E> root;
    private int modCount = 0;

    public Tree(E root) {
        this.root = new Node(root);
    }

    @Override
    public boolean add(Comparable parent, Comparable child) {
        Optional<Node<E>> parnode = findBy(parent);
        if (parnode.isPresent() && parent.compareTo(child) == -1) {
            if (!findBy(child).isPresent()) {
                parnode.get().add(new Node(child));
                modCount++;
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(Comparable value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> datain = new LinkedList<>();
        datain.offer(this.root);
        while (!datain.isEmpty()) {
            Node<E> el = datain.poll();
            if (el.eqValue((E) value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                datain.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            if (((Node) it.next()).leaves().size() > 2) {
                return false;
            }
        }
        return true;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Queue<Node<E>> data = new LinkedList<>();
            private Node<E> node;
            private int modCnt = modCount;

            {
                data.offer(root);
            }

            @Override
            public boolean hasNext() {
                if (this.modCnt != modCount) {
                    throw new ConcurrentModificationException("Структура изменилась");
                }
                if (!data.isEmpty()) {
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("элемент не найден");
                }
                node = data.poll();
                for (Node<E> elem : node.leaves()) {
                    data.offer(elem);
                }
                return node;
            }
        };
    }
}
