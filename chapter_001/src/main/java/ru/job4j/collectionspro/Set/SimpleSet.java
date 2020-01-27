package ru.job4j.collectionspro.Set;

import ru.job4j.collectionspro.generics.SimpleArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E>{
    SimpleArray<E> arr = new SimpleArray<E>();

    public void add(E elem) {
        Iterator<E> it = arr.iterator();
        while (it.hasNext()) {
            if (it.next().equals(elem)) {
                return;
            }
        }
        arr.add(elem);
    }

    @Override
    public Iterator<E> iterator() {
        return arr.iterator();
    }
}
