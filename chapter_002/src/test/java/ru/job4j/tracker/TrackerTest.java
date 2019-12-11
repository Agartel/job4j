package ru.job4j.tracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerKnowsItId() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        assertThat(item.getId(), is(tracker.findById(item.getId()).getId()));
    }
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenAddNewNItemThenGetNItems() {
        boolean result = false;
        Tracker tracker = new Tracker();
        Item[] srcitems = {new Item ("test1"), new Item ("test2"), new Item ("test3")};
        for (Item itm : srcitems) {
            tracker.add(itm);
        }
        Item[] dstitems = tracker.findAll();
        for (int i = 0; i < srcitems.length; i++) {
            if (srcitems[i] != dstitems[i]) {
                break;
            }
            if (i == srcitems.length - 1) {
                result = true;
            }
        }
        assertThat(result, is(true));
    }
    @Test
    public void whenAddNewNItemThenGetMItemsByCondition() {
        boolean result = false;
        Tracker tracker = new Tracker();
        Item[] srcitems = {new Item ("test1"), new Item ("test2"), new Item ("test1")};
        for (Item itm : srcitems) {
            tracker.add(itm);
        }
        Item[] dstitems = tracker.findByName("test1");

        assertThat(dstitems.length == 2, is(true));
    }
}
