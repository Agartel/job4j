package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class ShowActionTest {
    @Test
    public void whenFindAll() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Item item = new Item("item1");
        Tracker tracker = new Tracker();
        tracker.add(item);
        ShowAction action = new ShowAction();
        System.out.println(action.name());
        action.execute(null, tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Show all items")
                .add("ID: " + item.getId())
                .add("Name: " + item.getName())
                .add("===================")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
