package ru.job4j.colspro.list;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public static boolean hasCycle(Node first) {
        Node nodecurrent = first.next;
        while (nodecurrent != null) {
            if (nodecurrent == first || nodecurrent == nodecurrent.next) {
                return true;
            }
            nodecurrent = nodecurrent.next;
        }
        return false;
    }
}
