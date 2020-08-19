package ru.job4j.design.lsp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;

public class ControllQuality {
    private Storage warehouse;
    private Storage shop;
    private Storage trash;

    public ControllQuality() {
        this.warehouse = new WareHouse();
        this.shop = new Shop();
        this.trash = new Trash();
    }

    public Storage getWarehouse() {
        return this.warehouse;
    }

    public Storage getShop() {
        return this.shop;
    }

    public Storage getTrash() {
        return this.trash;
    }

    public void distribute(Food food) {
        Storage storage;
        Long diff1 = Duration.between(food.getCreateDate(), LocalDateTime.now()).toSeconds();
        Long diff2 = Duration.between(food.getCreateDate(), food.getExpireDate()).toSeconds();
        Double prc = (double)diff1 / diff2  * 100;
        if (prc < 25) {
            storage = warehouse;
        } else if (prc >= 25 && prc < 100) {
            storage = shop;
            if (prc >= 75) {
                food.setDisscount(food.getPrice() * 10 / 100);
            }
        } else {
            storage = trash;
        };
        storage.add(food);
    }
}
