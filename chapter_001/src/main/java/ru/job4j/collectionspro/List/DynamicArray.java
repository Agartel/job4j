package ru.job4j.collectionspro.List;


import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {

    private Object[] container = new Object[3];
    private int idx = 0;
    private int modCount = 0;

    private Object[] grow() {
        int oldCapacity = container.length;
        int newCapacity = oldCapacity + Math.max(1, (oldCapacity >> 1));
        return container = Arrays.copyOf(container, newCapacity);
    }
    public void add(T model)  {
        modCount++;
        if (idx == container.length) {
            grow();
        }
        this.container[idx++] = model;
    }

    public T get(int index) {
        if (index <0 ) {
            throw new IndexOutOfBoundsException ("Индекс не может быть отрицательным");
        }
        return (T)this.container[index];
    }

    public int getModCount() {
        return modCount;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private T[] arr = (T[])container;
            private int index = 0;
            private int modCnt = modCount;

            private void checkChanges() {
                if (modCnt != modCount) {
                    throw new ConcurrentModificationException();
                };
            }

            @Override
            public boolean hasNext() {
                checkChanges();
                return index < arr.length && arr[index] != null;
            }

            @Override
            public T next() {
                checkChanges();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                };
                return arr[index++];
            }
        };
    }
}
