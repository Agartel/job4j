package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private List<Item> items;
    private ExtendInput input;

    public Menu(List<Item> items, ExtendInput input) {
        this.items = items;
        this.input = input;
    }


    private void showSubSections(String subpath, List<Item> itms) {
        String path;
        int delimsize = (subpath.split("\\.").length + 1) * 3;
        for (int i = 0; i < itms.size(); i++) {
            Item itm = itms.get(i);
            path = subpath + (i + 1) + ".";
            System.out.println(String.format("%" + delimsize + "s", " ").replace(' ', '-') + " " + itm.getName() + " " + path);
            showSubSections(path, itm.getItems());
        }
    }

    public void showMenu() {
        String section;
        for (int i = 0; i <  items.size(); i++) {
            section = Integer.toString(i + 1) + ".";
            System.out.println("---" + " " + items.get(i).getName() + " " + section);
            showSubSections(section, items.get(i).getItems());
        }
    }

    public void init() {
        showMenu();
        int[] answer = input.askArray("Please, select partition: ");
        Item item = items.get(answer[0] - 1);
        for (int i = 1; i < answer.length; i++) {
            item = item.getItems().get(answer[i] - 1);
        }
        if (item != null) {
            item.execute();
        }
    }

    public static void main(String[] args) {
        ExtendInput input = new ConsoleInput();
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
    }
}
