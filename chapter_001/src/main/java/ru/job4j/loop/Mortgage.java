package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 0;
        double balance = amount;
        while (balance > 0) {
            balance = balance + (balance * percent / 100) - salary;
            year++;
        }
        return year;
    }
}
