package ru.job4j.collectionspro.Set;

import ru.job4j.collectionspro.generics.SimpleArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E>{
    private SimpleArray<E> arr = new SimpleArray<E>();
    public boolean Contains(E elem) {
        Iterator<E> it = arr.iterator();
        while (it.hasNext()) {
            if (it.next().equals(elem)) {
                return false;
            }
        }
        return true;
    }

    public void add(E elem) {
      if (Contains(elem)) {
          arr.add(elem);
      }
    }

    @Override
    public Iterator<E> iterator() {
        return arr.iterator();
    }
}
