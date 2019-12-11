package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        items[position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int idx = 0; idx <= position; idx++) {
            if (id.equals(items[idx].getId())) {
                items[idx] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int idx = 0; idx <= position; idx++) {
            if (id.equals(items[idx].getId())) {
                items[idx] = null;
                result = true;
                break;
            }
        }
        return result;
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
        return elems;
    }

     public Item findById(String id) {
        Item item = null;
         for (int idx = 0; idx <= position; idx++) {
             if (id.equals(items[idx].getId())) {
                 item = items[idx];
                 break;
             }
         }
         return item;
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
