package ru.job4j.oop;


public class Battery {
    private int value;

    public Battery(int size) {
        this.value = size;
    }

    public void exchange(Battery another) {
        int tmp = this.value;
        this.value = this.value - another.value;
        another.value = another.value + tmp;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(5);
        System.out.println("first : " + first.value + ". second : " + second.value);
        first.exchange(second);
        System.out.println("first : " + first.value + ". second : " + second.value);

    }
}