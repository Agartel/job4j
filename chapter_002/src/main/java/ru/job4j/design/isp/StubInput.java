package ru.job4j.design.isp;

public class StubInput implements ExtendInput {
    @Override
    public int[] askArray(String question) {
        int[] result = new int[3];
        result[0] = 3;
        result[1] = 1;
        result[2] = 2;
        return result;
    }
}
