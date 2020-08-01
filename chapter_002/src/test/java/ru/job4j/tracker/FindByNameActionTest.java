package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindByNameActionTest {
    @Test
    public void whenFindByName() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Item item = new Item("item1");
        ITracker tracker = new Tracker();
        tracker.add(item);
        FindByNameAction action = new FindByNameAction();
        System.out.println("Enter name:");
        StubInput input = new StubInput(new String[] {"item1"});
        System.out.println(action.name());
        action.execute(input, tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Enter name:")
                .add("Find items by name")
                .add("ID: " + item.getId())
                .add("Name: " + item.getName())
                .add("===================")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
