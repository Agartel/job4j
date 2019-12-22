package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
    private final List<Item> items = new ArrayList<Item>();
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        position++;
        return item;
    }

    public boolean delete(String id) {
        boolean result = false;
        int idx = this.indexOf(id);
        items.remove(idx);
        position--;
        result = true;
        return result;
    }
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index != position; index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    public List<Item> findAll() {
        List<Item> elems = new ArrayList<Item>();
        for (Item itm : items) {
            elems.add(itm);
        }
        return elems;
    }

    public List<Item> findByName(String key) {
        List<Item> elems = new ArrayList<Item>();
        for (Item itm : items) {
            if (key.equals(itm.getName())) {
                elems.add(itm);
            }
        }
        return elems;
    }

     public Item findById(String id) {
        Item itm = null;
        int idx = indexOf(id);
         if (idx >= 0) {
             itm = items.get(idx);
         }
        return itm;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        items.set(indexOf(id), item);
        result = true;
        return result;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
