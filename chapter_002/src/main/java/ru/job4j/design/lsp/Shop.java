package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Shop implements Storage {
    private List<Food> products = new ArrayList<Food>();

    @Override
    public void add(Food food) {
        if (calculatePrc(food) >= 75) {
            food.setDisscount(food.getPrice() * 10 / 100);
        }
        products.add(food);
    }

    @Override
    public boolean accept(Food food) {
        Double prc = calculatePrc(food);
        if (prc >= 25 && prc < 100) {
            return true;
        }
        return false;
    }

    @Override
    public List<Food> clear() {
        List<Food> products = this.products;
        this.products = null;
        return products;
    }
}