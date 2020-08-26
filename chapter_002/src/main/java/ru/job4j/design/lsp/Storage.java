package ru.job4j.design.lsp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public interface Storage {
    public default Double calculatePrc(Food food) {
        Long diff1 = Duration.between(food.getCreateDate(), LocalDateTime.now()).toSeconds();
        Long diff2 = Duration.between(food.getCreateDate(), food.getExpireDate()).toSeconds();
        return (double) diff1 / diff2  * 100;
    };
    public void add(Food food);
    public boolean accept(Food food);
    public List<Food> clear();
    public List<Food> getProducts();
}
