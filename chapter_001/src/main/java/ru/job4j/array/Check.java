package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
            if  (data[i] != data[0]) {
                break;
            }
            if (i == data.length - 1) {
                result = true;
            }
        }
        return result;
    }
}




