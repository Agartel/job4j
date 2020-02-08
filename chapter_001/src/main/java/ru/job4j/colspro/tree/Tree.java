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
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue((E) value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Queue<Node<E>> data = new LinkedList<>();
            private Node<E> result;
            private int modCnt = modCount;

            {
                data.offer(root);
            }

            @Override
            public boolean hasNext() {
                if (this.modCnt != modCount) {
                    throw new ConcurrentModificationException("Структура изменилась");
                }
                while (!data.isEmpty()) {
                    result = data.poll();
                    if (result != null) {
                        for (Node<E> child : result.leaves()) {
                            data.offer(child);
                        }
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("элемент не найден");
                }
                return result.getValue();
            }
        };
    }
}
