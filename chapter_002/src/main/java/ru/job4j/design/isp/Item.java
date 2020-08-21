package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

public class Item implements Action {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public void execute() {
        System.out.println("You run a " + getName() + " partition");
    }
}
