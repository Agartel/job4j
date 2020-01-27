package ru.job4j.collectionspro.Set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNewElemThenssetayAutoExtend() {
        SimpleSet<Integer> sset = new SimpleSet<Integer>();
        sset.add(1);
        sset.add(2);
        sset.add(1);
        Iterator<Integer> it = sset.iterator();
        assertThat(it.next(),is(1));
        assertThat(it.next(),is(2));
        assertFalse(it.hasNext());
    }


}