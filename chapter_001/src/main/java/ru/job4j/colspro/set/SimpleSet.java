package ru.job4j.colspro.set;

import ru.job4j.colspro.generics.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> arr = new SimpleArray<E>();
    public boolean contains(E elem) {
        Iterator<E> it = arr.iterator();
        if (elem != null) {
            while (it.hasNext()) {
                if (Objects.equals(it.next(), elem)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void add(E elem) {
      if (contains(elem)) {
          arr.add(elem);
      }
    }

    @Override
    public Iterator<E> iterator() {
        return arr.iterator();
    }
}
