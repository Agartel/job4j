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
                while (!iter.hasNext()) {
                    if (iter == null) {
                        iter.next();
                    }  else if (!it.hasNext()) {
                        return false;
                    }  else {
                        while (it == null || !it.hasNext()) {
                           iter = it.next();
                        }
                    }
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
