package ru.job4j.collectionspro.generics;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] array = new Object[3];
    private int idx = 0;

    public void add(T model) throws IndexOutOfBoundsException {
        this.array[idx++] = model;
    }

    public void set(int index, T model) {
        this.array[index] = model;
    }

    public void remove(int index) {
        this.array[index] = null;
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - 1 - index );
    }

    public T get(int index) {
        return (T)this.array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private T[] arr = (T[])array;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < arr.length;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }
}
