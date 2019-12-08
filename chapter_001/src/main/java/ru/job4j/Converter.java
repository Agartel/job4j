package ru.job4j;

public class Converter {
    public static float rubleToEuro(int value) {
        return (float) value / 70;
    }

    public static float rubleToDollar(int value) {
        return (float) value / 60;
    }

    public static float dollarToRuble(int value) {
        return (float) value * 60;
    }

    public static float euroToRuble(int value) {
        return (float) value * 70;
    }

    public static void main(String[] args) {
        float euro = rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");
        float dollar = rubleToDollar(74);
        System.out.println("74 rubles are " + dollar + " dollar.");
        float ruble = dollarToRuble(65);
        System.out.println("65 dollars are " + ruble + " ruble.");
        ruble = euroToRuble((13));
        System.out.println("13 euros are " + ruble + " ruble.");
    }
}
