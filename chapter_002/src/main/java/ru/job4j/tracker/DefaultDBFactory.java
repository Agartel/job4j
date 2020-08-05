package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DefaultDBFactory implements DBFactory {
    private Connection connection;
    @Override
    public Connection getConnect(String file) {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream(file)) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            return connection;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
