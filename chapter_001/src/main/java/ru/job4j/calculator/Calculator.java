package ru.job4j.calculator;

/**
 * Package for calculate task.
 * @author Alexander Gartel (gartel47@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    public static void main(String[] args) {
        add(1, 1);
        div(5, 4);
        multiply(3, 6);
        subtract(9, 1);
    }

    /**
     * Сложение
     * @param  first первый аргумент
     * @param  second второй аргумент
     * @return результат
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + "+" + second + " = " + result);
    }

    /**
     * Деление
     * @param  first первый аргумент
     * @param  second второй аргумент
     * @return результат
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + "/" + second + " = " + result);
    }

    /**
     * Умножение
     * @param  first первый аргумент
     * @param  second второй аргумент
     * @return результат
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + "*" + second + " = " + result);
    }

    /**
     * Разность
     * @param  first первый аргумент
     * @param  second второй аргумент
     * @return результат
     */
    public static void subtract(double first, double second) {
        double result = first - second;
        System.out.println(first + "-" + second + " = " + result);
    }
}
