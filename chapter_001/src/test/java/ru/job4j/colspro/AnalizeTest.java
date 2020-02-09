package ru.job4j.colspro;

import org.junit.Test;
import ru.job4j.colspro.list.DynamicArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenFirstDeleteAndInsertNewSecondUpdateThirdNotUpdateThenAddedIs1ChangedIs1DeletedIs1() {
        List<Analize.User> previous = Arrays.asList(new Analize.User(1, "e"),
                new Analize.User(2, "a"),
                new Analize.User(3, "b"));
        List<Analize.User> current = Arrays.asList(new Analize.User(5, "w"),
                new Analize.User(2, "xx"),
                new Analize.User(3, "b"));
        Analize an = new Analize();
        Analize.Info info = new Analize.Info();
        info = an.diff(previous, current);
        assertThat(info.added, is(1));
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(1));
    }

    @Test
    public void whenFirstDeleteAndInsNewSecondUpdateThirdNotUpdateForthInsThenAddedIs2ChangedIs1DeletedIs1() {
        List<Analize.User> previous = Arrays.asList(new Analize.User(1, "e"),
                new Analize.User(2, "a"),
                new Analize.User(3, "b"));
        List<Analize.User> current = Arrays.asList(new Analize.User(5, "w"),
                new Analize.User(2, "xx"),
                new Analize.User(3, "b"),
                new Analize.User(4, "dddd"));
        Analize an = new Analize();
        Analize.Info info = new Analize.Info();
        info = an.diff(previous, current);
        assertThat(info.added, is(2));
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(1));
    }

}