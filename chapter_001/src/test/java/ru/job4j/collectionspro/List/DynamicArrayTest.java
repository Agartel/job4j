package ru.job4j.collectionspro.List;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {

    private DynamicArray<Integer> arr;

    @Test
    public void whenAddNewElemThenArrayAutoExtend() {
        arr = new DynamicArray<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        assertThat(arr.get(3), is(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldReturnExceptionIdxOutOfBounds () {
        arr = new DynamicArray<>();
        arr.add(1);
        arr.add(2);
        Iterator<Integer> it = arr.iterator();
        arr.add(3);
        int tmp = it.next();
    }

}