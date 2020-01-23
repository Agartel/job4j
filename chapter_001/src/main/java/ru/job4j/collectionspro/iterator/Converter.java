package ru.job4j.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            Iterator<Integer> iter;

            {
                if (it.hasNext()) {
                    iter = it.next();
                } else {
                    throw new NoSuchElementException("Не найден элемент");
                }
            }

            @Override
            public boolean hasNext() {
                boolean res = false;
                if (iter.hasNext()) {
                        res = true;
                }
                return res;
            }

            @Override
            public Integer next() {
                int res = 0;
                if (iter.hasNext()) {
                    res = iter.next();
                    if (!iter.hasNext() && it.hasNext()) {
                        iter = it.next();
                    }
                } else {
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Не найден элемент");
                    }
                }
                return res;
            }
        };
    }
}
