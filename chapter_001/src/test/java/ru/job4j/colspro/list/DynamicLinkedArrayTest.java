package ru.job4j.colspro.list;

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
        assertThat(arr.get(0), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTryGetElemOutBoundThendReturnException() {
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
    public void shouldReturnExceptionConcurentMod() {
        arr = new DynamicLinkedArray<>();
        arr.add(1);
        arr.add(2);
        Iterator<Integer> it = arr.iterator();
        arr.add(3);
        int tmp = it.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenDelete2ElemThenReturnItValAndGet3And1ElemAndThenGetExcept() {
        arr = new DynamicLinkedArray<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        assertThat(arr.remove(1), is(2));
        assertThat(arr.get(0), is(3));
        assertThat(arr.get(1), is(1));
        arr.get(2);
    }
}