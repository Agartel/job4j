package ru.job4j.colspro.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {

    @Test
    public void whenAddNewElemThenStackAutoExtend() {
        SimpleStack<Integer> stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
        assertNull(stack.poll());
    }

    @Test
    public void shouldAddDeleteAddCorrectWorks() {
        SimpleStack<Integer> stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        stack.push(44);
        assertThat(stack.poll(), is(44));
        assertThat(stack.poll(), is(1));
        assertNull(stack.poll());
    }
}