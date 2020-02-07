package ru.job4j.colspro.list;

public class SimpleStack<T> {
    private DynamicLinkedArray<T> list = new DynamicLinkedArray<T>();
    private int idxpush = 0;
    private T tmp;

    public T poll() {
        T result = idxpush > 0 ? list.remove(0) : null;
        idxpush--;
        return result;
    }

    public void push(T value) {
        list.add(value);
        idxpush++;
    }
}
