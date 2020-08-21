package ru.job4j.design.isp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void initMenuWorkCorrect() {
        ExtendInput input = new StubInput();
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("aaaaa");
        item1.addItem(new Item("bbbbb"));
        item1.addItem(new Item("ccccc"));
        items.add(item1);
        Item item2 = new Item("zzzzz");
        item2.addItem(new Item("yyyyy"));
        item2.addItem(new Item("nnnnn"));
        items.add(item2);
        Item item3 = new Item("jjjjj");
        Item item31 = new Item("kkkkkk");
        item31.addItem(new Item("iiiiii"));
        item31.addItem(new Item("pppppp"));
        item3.addItem(item31);
        item3.addItem(new Item("vvvvvv"));
        items.add(item3);
        Menu menu = new Menu(items, input);
        menu.init();
        StringBuilder text = new StringBuilder();
        text.append("--- aaaaa 1.").append(System.lineSeparator())
                .append("------ bbbbb 1.1.").append(System.lineSeparator())
                .append("------ ccccc 1.2.").append(System.lineSeparator())
            .append("--- zzzzz 2.").append(System.lineSeparator())
                .append("------ yyyyy 2.1.").append(System.lineSeparator())
                .append("------ nnnnn 2.2.").append(System.lineSeparator())
            .append("--- jjjjj 3.").append(System.lineSeparator())
                .append("------ kkkkkk 3.1.").append(System.lineSeparator())
                     .append("--------- iiiiii 3.1.1.").append(System.lineSeparator())
                     .append("--------- pppppp 3.1.2.").append(System.lineSeparator())
                .append("------ vvvvvv 3.2.").append(System.lineSeparator())
                .append("You run a pppppp partition").append(System.lineSeparator())
        ;
        Assert.assertEquals(text.toString(), output.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}