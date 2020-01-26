package ru.job4j.collectionspro.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicLinkedArray<T> implements Iterable<T> {
    private int modCount = 0;
    private Node<T> first;
    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        modCount++;
        Node<T> newElem = new Node<T>(data);
        newElem.next = this.first;
        this.first = newElem;
    }

    public T get(int index) {
        Node<T> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int modCnt = modCount;
            private Node<T> current = first;

            private void checkChanges() {
                if (modCnt != modCount) {
                    throw new ConcurrentModificationException();
                };
            }

            @Override
            public boolean hasNext() {
                checkChanges();
                return current != null && current.data != null;
            }

            @Override
            public T next() {
                checkChanges();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T res = current.data;
                current = current.next;
                return res;
            }
        };
    }


}
