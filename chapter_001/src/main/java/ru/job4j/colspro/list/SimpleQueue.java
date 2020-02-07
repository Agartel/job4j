package ru.job4j.colspro.list;

public class SimpleQueue<T> {
    private SimpleStack<T> stack1 = new SimpleStack<T>();
    private SimpleStack<T> stack2 = new SimpleStack<T>();

    public T poll() {
        T tmp = stack2.poll();
        if (tmp == null) {
            while ((tmp = stack1.poll()) != null) {
                stack2.push(tmp);
            }
            tmp = stack2.poll();
        }
        return tmp;
    }

    public void push(T value) {
        stack1.push(value);
    }
}
