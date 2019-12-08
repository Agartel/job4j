package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < (int) (array.length / 2)) {
                tmp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = tmp;
            } else {
                break;
            }
        }
        return array;
    }
}
