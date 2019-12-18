package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            if (item != null) {
                System.out.println("ID: " + item.getId());
                System.out.println("Name: " + item.getName());
                System.out.println("===================");
            }
        }
        return true;
    }
}

