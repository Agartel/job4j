package ru.job4j.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;
import java.util.Random;

public class TrackerSgl3 {
    private static final TrackerSgl3 INSTANCE = new TrackerSgl3();
    Tracker tracker = new Tracker();

    private TrackerSgl3() {
    }

    public static TrackerSgl3 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TrackerSgl3 trcksgl =  TrackerSgl3.getInstance();
    }
}
