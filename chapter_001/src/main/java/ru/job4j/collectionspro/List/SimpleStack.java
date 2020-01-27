package ru.job4j.collectionspro.List;

public class SimpleStack<T> {
    private DynamicLinkedArray<T> list = new DynamicLinkedArray<T>();
    private int idxpush = 0;
    private T tmp;

    public T poll() {
        return idxpush > 0 ? list.get(--idxpush) : null;
    }

    public void push(T value) {
        list.add(value);
        idxpush++;
    }
}
