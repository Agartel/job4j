package ru.job4j.design.lsp;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void whenLessThan25ThenWareHouse() throws InterruptedException {
        ControllQuality cntrl = new ControllQuality();
        LocalDateTime ltm1 = LocalDateTime.now();
        LocalDateTime ltm2 = LocalDateTime.now().plusSeconds(10);
        Food food1 = new Food("apple", ltm1, ltm2, 400, 0);
        Thread.sleep(2000);
        cntrl.distribute(food1);
        Food result = null;
        for (Storage storage : cntrl.getStorages()) {
            if (storage instanceof WareHouse) {
                result = storage.clear().get(0);
                break;
            }
        }
        assertEquals(result.getName(), "apple");
    }

    @Test
    public void whenBetween25And75ThenShopAndDiscountIs0() throws InterruptedException {
        ControllQuality cntrl = new ControllQuality();
        LocalDateTime ltm1 = LocalDateTime.now();
        LocalDateTime ltm2 = LocalDateTime.now().plusSeconds(10);
        Food food1 = new Food("apple", ltm1, ltm2, 400, 0);
        Thread.sleep(5000);
        cntrl.distribute(food1);
        Food result = null;
        for (Storage storage : cntrl.getStorages()) {
            if (storage instanceof Shop) {
                result = storage.clear().get(0);
                break;
            }
        }
        assertEquals(result.getName(), "apple");
        assertThat(result.getDisscount(), is(0));
    }

    @Test
    public void whenBiggerThan75ThenShopAndDiscountIs40() throws InterruptedException {
        ControllQuality cntrl = new ControllQuality();
        LocalDateTime ltm1 = LocalDateTime.now();
        LocalDateTime ltm2 = LocalDateTime.now().plusSeconds(10);
        Food food1 = new Food("apple", ltm1, ltm2, 400, 0);
        Thread.sleep(8000);
        cntrl.distribute(food1);
        Food result = null;
        for (Storage storage : cntrl.getStorages()) {
            if (storage instanceof Shop) {
                result = storage.clear().get(0);
                break;
            }
        }
        assertEquals(result.getName(), "apple");
        assertThat(result.getDisscount(), is(40));
    }

    @Test
    public void whenBiggerThan100ThenTrash() throws InterruptedException {
        ControllQuality cntrl = new ControllQuality();
        LocalDateTime ltm1 = LocalDateTime.now();
        LocalDateTime ltm2 = LocalDateTime.now().plusSeconds(10);
        Food food1 = new Food("apple", ltm1, ltm2, 400, 0);
        Thread.sleep(10000);
        cntrl.distribute(food1);
        Food result = null;
        for (Storage storage : cntrl.getStorages()) {
            if (storage instanceof Trash) {
                result = storage.clear().get(0);
                break;
            }
        }
        assertEquals(result.getName(), "apple");
    }

    @Test
    public void resortCheckEachStorageWhenPrcLifeFoodExpireThenMoveToNextStage() throws InterruptedException {
        ControllQuality cntrl = new ControllQuality();
        Food food1 = new Food("apple", LocalDateTime.now(), LocalDateTime.now().plusSeconds(35), 400, 0);
        cntrl.distribute(food1);
        Food result = null;
        for (Storage storage : cntrl.getStorages()) {
            if (storage instanceof WareHouse) {
                result = storage.getProducts().get(0);
                break;
            }
        }
        assertEquals(result.getName(), "apple");
        Food food2 = new Food("banana", LocalDateTime.now(), LocalDateTime.now().plusSeconds(10), 400, 0);
        Thread.sleep(8000);
        cntrl.distribute(food2);
        for (Storage storage : cntrl.getStorages()) {
            if (storage instanceof Shop) {
                result = storage.getProducts().get(0);
                break;
            }
        }
        assertEquals(result.getName(), "banana");
        assertThat(result.getDisscount(), is(40));
        Thread.sleep(2000);
        cntrl.resort();
        for (Storage storage : cntrl.getStorages()) {
            if (storage instanceof Shop) {
                result = storage.clear().get(0);
                break;
            }
        }
        assertEquals(result.getName(), "apple");
        assertThat(result.getDisscount(), is(0));
        for (Storage storage : cntrl.getStorages()) {
            if (storage instanceof Trash) {
                result = storage.clear().get(0);
                break;
            }
        }
        assertEquals(result.getName(), "banana");
        assertThat(result.getDisscount(), is(40));
    }
}