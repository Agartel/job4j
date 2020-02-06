package ru.job4j.colspro.list;

import org.junit.Test;
import org.junit.Before;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDelElemFrom0PosThenGetSecondElemFrom1Pos() {
        list.delete();
        assertThat(list.get(0), is(2));
    }
    @Test(expected = NoSuchElementException.class)
    public void whenTryDelEmptyElemThenGetException() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.delete();
    }
}