package ru.job4j.collectionspro.List;

public class SimpleQueue<T> {
    private SimpleStack<T> stack1 = new SimpleStack<T>();
    private SimpleStack<T> stack2 = new SimpleStack<T>();
    private T tmp;
    private int idxpush1 = 0;
    private int idxpush2 = 0;

    public T poll() {
        do {
            tmp = stack1.poll();
            if (tmp == null) {
                break;
            }
            stack2.push(tmp);
            idxpush2++;
        } while (true);
        return idxpush2 <= idxpush1 ? stack2.poll() : null;
    }

    public void push(T value) {
        stack1.push(value);
        idxpush1++;
    }
}
