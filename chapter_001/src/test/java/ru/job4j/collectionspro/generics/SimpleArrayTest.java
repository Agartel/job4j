package ru.job4j.collectionspro.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    private SimpleArray<Integer> sa = new SimpleArray<>();

    @Before
    public void setUp(){
        sa.add(5);
        sa.add(6);
        sa.add(7);
    }

    @Test
    public void afterFillArrayShouldGet3Elems () {
        int cnt = 0;
        for (Integer elem : sa) {
            cnt++;
        }
        Assert.assertThat(cnt, is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldReturnExceptionIdxOutOfBounds () {
        sa.add(8);
    }

    @Test
    public void whenSet135To2ElemThenGet135From2Elem () {
        sa.set(2, 135);
        Assert.assertThat(sa.get(2), is(135));
    }

    @Test
    public void whenRemove1ElemThenGet2Elem () {
        sa.remove(1);
        Assert.assertThat(sa.get(2), is(7));
    }

    @Test
    public void testsThatNextMethodWorks () {
        Iterator<Integer> it = sa.iterator();
        Assert.assertThat(it.next(), is(5));
        Assert.assertThat(it.next(), is(6));
        Assert.assertThat(it.next(), is(7));
    }

    @Test
    public void hasNextInvocationDoesntAffectRetrievalOrder () {
        Iterator<Integer> it = sa.iterator();
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(5));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(6));
        Assert.assertThat(it.hasNext(), is(true));
        Assert.assertThat(it.next(), is(7));
        Assert.assertThat(it.hasNext(), is(false));
    }

    @Test
    public void afterRetrievalHasNextWorks () {
        Iterator<Integer> it = sa.iterator();
        Assert.assertThat(it.next(), is(5));
        Assert.assertThat(it.next(), is(6));
        Assert.assertThat(it.next(), is(7));
        Assert.assertThat(it.hasNext(), is(false));
    }
}