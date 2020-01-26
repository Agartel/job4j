package ru.job4j.collectionspro.List;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicLinkedArrayTest {
    private DynamicLinkedArray<Integer> arr;

    @Test
    public void whenAddNewElemThenArrayAutoExtend() {
        arr = new DynamicLinkedArray<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        assertThat(arr.get(0), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void WhenTryGetElemOutBoundThendReturnException () {
        arr = new DynamicLinkedArray<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Iterator<Integer> it = arr.iterator();
        int tmp = it.next();
        tmp = it.next();
        tmp = it.next();
        tmp = it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldReturnExceptionConcurentMod () {
        arr = new DynamicLinkedArray<>();
        arr.add(1);
        arr.add(2);
        Iterator<Integer> it = arr.iterator();
        arr.add(3);
        int tmp = it.next();
    }
}