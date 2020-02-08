package ru.job4j.colspro.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E extends Comparable<E>> implements SimpleTree {
    private Node<E> root;

    public Tree(E root) {
        this.root = new Node(root);
    }

    @Override
    public boolean add(Comparable parent, Comparable child) {
        Optional<Node<E>> parnode = findBy(parent);
        if (parnode.isPresent() && parent.compareTo(child) == -1) {
            if (!findBy(child).isPresent()) {
                parnode.get().add(new Node(child));
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
        return null;
    }
}
