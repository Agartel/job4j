package ru.job4j.collectionspro;


import java.util.Iterator;

public class IteratorDoubleArray implements Iterator {

    private int[][] value;
    private int i;
    private int j;

    public IteratorDoubleArray(final int[][] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return j < value[i].length;
    }

    @Override
    public Object next() {
        int res = value[i][j++];
        if (j == value[i].length && i < value.length - 1) {
            j = 0;
            i++;
        }
        return res;
    }
}
