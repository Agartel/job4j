package ru.job4j.design.lsp;

import java.util.List;
import java.util.function.Predicate;

public interface Storage {
    public void add(Food food);
    public List<Food> get(Predicate<Food> filter);
}
