package ru.job4j.tracker;

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerKnowsItId() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        assertThat(item.getId(), is(tracker.findById(item.getId()).getId()));
    }
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        ITracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        ITracker tracker = new Tracker();
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
        String tmp = tracker.findById(previous.getId()).getName();
        assertThat(tmp, is("test2"));
    }
    @Test
    public void whenAddNewNItemThenGetNItems() {
        boolean result = false;
        ITracker tracker = new Tracker();
        List<Item> srcitems = new ArrayList();
        srcitems.add(new Item("test1"));
        srcitems.add(new Item("test2"));
        srcitems.add(new Item("test3"));
        for (Item itm : srcitems) {
            tracker.add(itm);
        }
        List<Item> dstitems = tracker.findAll();
        for (int i = 0; i != srcitems.size(); i++) {
            if (!srcitems.get(i).equals(dstitems.get(i))) {
                break;
            }
            if (i == srcitems.size() - 1) {
                result = true;
            }
        }
        assertThat(result, is(true));
    }
    @Test
    public void whenAddNewNItemThenGetMItemsByCondition() {
        boolean result = false;
        ITracker tracker = new Tracker();
        List<Item> srcitems = new ArrayList();
        srcitems.add(new Item("test1"));
        srcitems.add(new Item("test2"));
        srcitems.add(new Item("test1"));

        for (Item itm : srcitems) {
            tracker.add(itm);
        }
        List<Item> dstitems = tracker.findByName("test1");

        assertThat(dstitems.size() == 2, is(true));
    }
    @Test
    public void whenDelete() {
        ITracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}
