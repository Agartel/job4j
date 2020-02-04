package ru.job4j.collectionspro.Set;

import ru.job4j.collectionspro.generics.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E>{
    private SimpleArray<E> arr = new SimpleArray<E>();
    public boolean сontains(E elem) {
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
      if (сontains(elem)) {
          arr.add(elem);
      }
    }

    @Override
    public Iterator<E> iterator() {
        return arr.iterator();
    }
}
