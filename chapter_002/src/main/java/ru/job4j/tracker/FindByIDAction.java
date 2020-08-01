package ru.job4j.tracker;

public class FindByIDAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        String id = input.askStr("Enter ID: ");
        Item itm = tracker.findById(id);
        if (itm != null) {
            System.out.println("Name: " + itm.getName());
        }
        return true;
    }
}

