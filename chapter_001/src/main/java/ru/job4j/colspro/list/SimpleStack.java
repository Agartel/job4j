package ru.job4j.colspro.list;

public class SimpleStack<T> {
    private DynamicLinkedArray<T> list = new DynamicLinkedArray<T>();
    private int idxpush = 0;
    private T tmp;

    public T poll() {
        T result = null;
        if (idxpush > 0) {
            result = list.remove(0);
            idxpush--;
        }
        return result;
    }

    public void push(T value) {
        list.add(value);
        idxpush++;
    }
}
