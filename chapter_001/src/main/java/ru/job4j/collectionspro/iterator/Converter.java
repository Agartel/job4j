package ru.job4j.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            Iterator<Integer> iter;

            {
                if (!it.hasNext()) {
                    throw new NoSuchElementException("Не найден элемент");
                }
                iter = it.next();
            }

            @Override
            public boolean hasNext() {
                if (!iter.hasNext()) {
                    while (it.hasNext()) {
                        iter = it.next();
                        if (iter != null && iter.hasNext()) {
                            return  true;
                        }
                    }
                    return false;
                }
                return true;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Не найден элемент");
                }
                return iter.next();
            }
        };
    }
}
