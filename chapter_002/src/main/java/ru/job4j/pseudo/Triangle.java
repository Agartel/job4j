package ru.job4j.pseudo;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        return pic
                .append("  ^  ")
                .append(" ^ ^ ")
                .append("^^^^^")
                .toString();
    }
}
