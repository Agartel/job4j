package ru.job4j.colspro.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void iteratorShouldCorrectWorks() {
        Tree<Integer> tree = new Tree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> it = tree.iterator();
        Object obj = it.next();
        assertThat(((Node) obj).getValue(), is(1));
        obj = it.next();
        assertThat(((Node) obj).getValue(), is(2));
        obj = it.next();
        assertThat(((Node) obj).getValue(), is(3));
        obj = it.next();
        assertThat(((Node) obj).getValue(), is(4));
        obj = it.next();
        assertThat(((Node) obj).getValue(), is(5));
        obj = it.next();
        assertThat(((Node) obj).getValue(), is(6));
        assertFalse(it.hasNext());
    }

    @Test
    public void whenAllTreeNodeIncludeLess3NodesThenItIsBinaryTree() {
        Tree<Integer> tree = new Tree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 5);
        tree.add(2, 3);
        tree.add(2, 4);
        tree.add(5, 6);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenOneOfAllTreeNodeIncludeBigger3NodesThenItIsNotBinaryTree() {
        Tree<Integer> tree = new Tree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 5);
        tree.add(2, 3);
        tree.add(2, 4);
        tree.add(5, 6);
        tree.add(5, 7);
        tree.add(5, 8);
        assertFalse(tree.isBinary());
    }
}