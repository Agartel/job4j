package ru.job4j.collectionspro.List;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {

    @Test
    public void whenAddNewElemThenstackayAutoExtend() {
        SimpleStack<Integer> stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.poll(), is(3));
    }
}