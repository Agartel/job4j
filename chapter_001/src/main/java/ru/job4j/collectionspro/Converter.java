package ru.job4j.collectionspro;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                boolean res = false;
                Iterator<Integer> iter;
                if (it.hasNext()) {
                    iter = it.next();
                    if (iter.hasNext()) {
                        res = true;
                    }
                }
                return res;
            }

            @Override
            public Integer next() {
                if (it.hasNext()) {
                    return it.next().next();
                } else {
                    throw new NoSuchElementException("Не найден элемент");
                }
            }
        };
    }
}
