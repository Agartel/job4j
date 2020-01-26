package ru.job4j.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    private int[] even;
    private int idx;
    private final String errtxt = "Чётный элемент не найден";

    public EvenIterator(final int[] even) {
        this.even = even;
    }

    @Override
    public boolean hasNext() {
        for (int i = idx; i < even.length; i++) {
            if (even[i] % 2 == 0) {
                idx = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException(errtxt);
        }
        return even[idx++];
    }
}
