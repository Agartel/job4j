package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Shop implements Storage {
    private List<Food> products = new ArrayList<Food>();

    @Override
    public void add(Food food) {
        products.add(food);
    }

    @Override
    public List<Food> get(Predicate<Food> filter) {
        return products.stream().filter(filter).collect(Collectors.toList());
    }
}