package ru.job4j.colspro.list;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public static boolean hasCycle(Node first) {
        if (first == null) {
            return false;
        }

        Node turtle = first;
        Node hare = first;

        while (hare.next != null && hare.next.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;

            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }
}
