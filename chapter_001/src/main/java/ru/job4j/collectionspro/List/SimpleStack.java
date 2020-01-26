package ru.job4j.collectionspro.List;

public class SimpleStack<T> {
    private DynamicLinkedArray<T> list = new DynamicLinkedArray<T>();
    private int idxpush = 0;
    private int idxpoll = 0;
    private T tmp;

    public T poll() {
        if (idxpush > 0) {
            tmp = list.get(idxpoll++);
            idxpush--;
        } else {
            tmp = null;
        }
        return tmp;
    }

    public void push(T value) {
        list.add(value);
        idxpush++;
    }
}
