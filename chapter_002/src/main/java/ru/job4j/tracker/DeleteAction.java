package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        String id = input.askStr("Enter ID: ");
        tracker.delete(id);
        return true;
    }
}
