package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public enum TrackerSgl1 {
    INSTANCE;
    Tracker tracker = new Tracker();

    public static void main(String[] args) {
        TrackerSgl1 trcksgl =  TrackerSgl1.INSTANCE;
    }
}
