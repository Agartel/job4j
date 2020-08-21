package ru.job4j.design.lsp;

public abstract class Car {
    private final int serialnum;
    private final int length;
    private final int weight;
    private int fuellevel = 0;

    public Car(int serialnum, int length, int weight) {
        this.serialnum = serialnum;
        this.length = length;
        this.weight = weight;
    }

    public void fillFuel() {
        fuellevel = fuellevel + 1;
    }
}
