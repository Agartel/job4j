package ru.job4j.design.lsp;

public class Car {
    private final int serialnum;
    private final int length;
    private final int height;
    private final int weight;
    private int fuellevel = 0;

    public Car(int serialnum, int length, int height, int weight) {
        this.serialnum = serialnum;
        this.length = length;
        this.height = height;
        this.weight = weight;
    }

    public void fillFuel() {
        fuellevel = fuellevel + 1;
    }
}
