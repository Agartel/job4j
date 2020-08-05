package ru.job4j.tracker;

import java.sql.Connection;

public interface DBFactory {
    public Connection getConnect(String file);
}
