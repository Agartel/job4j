package ru.job4j.colspro.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    @Test
    public void shouldFirstInputFirstOutputWorksCorrect() {
        SimpleQueue<Integer> queue = new SimpleQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        assertNull(queue.poll());
    }

    @Test
    public void whenNotSequanceAddThenFirstInputFirstOutputWorkCorrect() {
        SimpleQueue<Integer> queue = new SimpleQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        queue.push(66);
        assertThat(queue.poll(), is(3));
        assertThat(queue.poll(), is(66));
        assertNull(queue.poll());
    }

}