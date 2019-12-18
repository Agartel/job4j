package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSgl4 {
    Tracker tracker = new Tracker();

    private TrackerSgl4() {
    }

    public static TrackerSgl4 getInstance() {
        return Holder.INSTANCE;
    }
    private static final class Holder {
        private static final TrackerSgl4 INSTANCE = new TrackerSgl4();
    }
    public static void main(String[] args) {
        TrackerSgl4 trcksg =  TrackerSgl4.getInstance();
    }
}
