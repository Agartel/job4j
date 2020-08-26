package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WareHouse implements Storage {
    private List<Food> products = new ArrayList<Food>();

    @Override
    public void add(Food food) {
        products.add(food);
    }

    @Override
    public boolean accept(Food food) {
        if (calculatePrc(food) < 25) {
            return true;
        }
        return false;
    }

    @Override
    public List<Food> clear() {
        List<Food> products = this.products;
        this.products = new ArrayList<Food>();
        return products;
    }

    @Override
    public List<Food> getProducts() {
        return this.products;
    }

}
