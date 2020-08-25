package ru.job4j.design.lsp;

public abstract class Car {
    private final int serialnum;
    private final int length;
    private final int weight;

    public Car(int serialnum, int length, int weight) {
        this.serialnum = serialnum;
        this.length = length;
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }
}
