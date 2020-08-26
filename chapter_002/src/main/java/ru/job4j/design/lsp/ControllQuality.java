package ru.job4j.design.lsp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private final List<Storage> storages = new ArrayList<>();

    public ControllQuality() {
        this.storages.add(new WareHouse());
        this.storages.add(new Shop());
        this.storages.add(new Trash());
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void distribute(Food food) {
        for (Storage storage : storages) {
            if (storage.accept(food)) {
                storage.add(food);
                break;
            }
        }
    }

    public void resort() {
        List<Food> allProducsts = new ArrayList<>();
        for (Storage storage : storages) {
            allProducsts.addAll(storage.clear());
        }
        for (Food food : allProducsts) {
            distribute(food);
        }
    }
}
