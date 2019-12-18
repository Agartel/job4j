package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSgl2 {
    private static TrackerSgl2 instance;
    Tracker tracker = new Tracker();
    private TrackerSgl2() {
    }

    public static TrackerSgl2 getInstance() {
        if (instance == null) {
            instance = new TrackerSgl2();
        }
        return instance;
    }

    public static void main(String[] args) {
        TrackerSgl2 trcksgl =  TrackerSgl2.getInstance();
    }
}
