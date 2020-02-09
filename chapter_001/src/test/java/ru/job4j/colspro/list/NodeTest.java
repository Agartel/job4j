package ru.job4j.colspro.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void whenFirstPointNextToItSelfThenTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        first.next = first;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        assertTrue(Node.hasCycle(second));
    }

    @Test
    public void whenFourthPointNextToFirstThenTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        assertTrue(Node.hasCycle(second));
    }

    @Test
    public void whenThirdPointNextToSecondThenTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        first.next = second;
        second.next = third;
        third.next = second;
        fourth.next = null;
        assertTrue(Node.hasCycle(first));
    }
}