package ru.job4j.collectionspro;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    private int[] even;
    private int idx;

    public EvenIterator(final int[] even) {
        this.even = even;
    }

    private final boolean isEven(int number) {
        boolean res = false;
        if (number % 2 == 0) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    private final boolean pointToEven() {
        boolean res = false;
        for (int i = idx; i < even.length; i++) {
            if (isEven(even[i])) {
                idx = i;
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return  pointToEven();
    }

    @Override
    public Object next() {
        int res;
        String errtxt = "Чётный элемент не найден";
        if (pointToEven()) {
            res = even[idx++];
        } else {
            throw new NoSuchElementException(errtxt);
        };
        pointToEven();
        return res;
    }
}
