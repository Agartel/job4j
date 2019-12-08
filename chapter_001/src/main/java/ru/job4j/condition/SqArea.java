package ru.job4j.condition;

public class SqArea {
    public static double square(int p, int k) {
        double h = (double) p / (2 + (k + 1));
        double l = h * (double) k;
        double s = l * h;
        return s;
    }

    public static void main(String[] args) {
        int p = 6;
        int k = 2;
        double result1 = square(p, k);
        System.out.println(" p = " + p + ", k = " + k + ", real = " + result1);
    }
}
