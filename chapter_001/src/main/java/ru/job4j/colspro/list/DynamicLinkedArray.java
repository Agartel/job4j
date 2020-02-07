package ru.job4j.colspro.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicLinkedArray<T> implements Iterable<T> {
    private int modCount = 0;
    private int size = 0;
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
        size++;
        Node<T> newElem = new Node<T>(data);
        newElem.next = this.first;
        this.first = newElem;
    }

    public T get(int index) {
        Node<T> result = this.first;
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Индекс не прошёл валидацию");
        }
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public T remove(int index) {
        T elem;
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Индекс не прошёл валидацию");
        }
        if (index == 0) {
            elem = first.data;
            if (this.first.next == null) {
                this.first = null;
            } else {
                this.first = this.first.next;
            }
        } else {
            Node<T> node1 = this.first;
            Node<T> node2 = null;
            for (int i = 0; i < index; i++) {
                if (i == index - 1) {
                   node2 = node1;
                }
                if (node1.next == null) {
                    break;
                }
                node1 = node1.next;
            }
            elem = node1.data;
            node2.next = node1.next;
        }
        modCount++;
        size--;
        return elem;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int modCnt = modCount;
            private Node<T> current = first;

            private void checkChanges() {
                if (modCnt != modCount) {
                    throw new ConcurrentModificationException();
                }
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
