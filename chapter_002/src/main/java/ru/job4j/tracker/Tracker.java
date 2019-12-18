package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        items[position++] = item;
        return item;
    }

    public boolean delete(String id) {
        boolean result = false;
        int idx = this.indexOf(id);
        if (idx != position - 1) {
            System.arraycopy(items, idx + 1, items, idx, (position  - (idx + 1)));
        }
        items[position - 1] = null;
        position--;
        result = true;
        return result;
    }
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index != position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    public Item[] findAll() {
        Item[] elems = new  Item[position];
        int idx = 0;
        for (Item itm : items) {
            if (itm != null) {
                elems[idx] = itm;
                idx++;
            }
        }
        if (idx != position) {
            elems = Arrays.copyOf(elems, idx);
        }
        return elems;
    }

    public Item[] findByName(String key) {
        Item[] elems = new  Item[position];
        int idx = 0;
        for (Item itm : items) {
            if (itm != null && key.equals(itm.getName())) {
                elems[idx] = itm;
                idx++;
            }
        }
        if (idx != position) {
            elems = Arrays.copyOf(elems, idx);
        }
        return elems;
    }

     public Item findById(String id) {
        Item itm = null;
        int idx = indexOf(id);
         if (idx >= 0) {
             itm = items[idx];
         }
        return itm;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        items[indexOf(id)] = item;
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
