package ru.job4j.collectionspro.List;

public class SimpleStack<T> {
    private DynamicLinkedArray<T> list = new DynamicLinkedArray<T>();
    private int idx = 0;
    public T poll() {
        return list.get(idx++);
    }

    public void push(T value) {
        list.add(value);
    }
}
