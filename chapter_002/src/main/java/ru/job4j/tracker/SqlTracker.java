package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store   {

    private Connection connection;

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO items (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, item.getName());
            stmt.executeUpdate();
            ResultSet genKey = stmt.getGeneratedKeys();
            if (genKey.next()) {
                item.setId(genKey.getString(1));
                return item;
            }
            return null;
        }
    }

    @Override
    public boolean replace(String id, Item item) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE items SET name = ? WHERE ID = ?")) {
            stmt.setString(1, item.getName());
            stmt.setInt(2, Integer.parseInt(id));
            stmt.executeUpdate();
            int count = stmt.getUpdateCount();
            if (count == 0) {
                return false;
            }
            return true;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM items WHERE ID = ?")) {
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                return false;
            }
            return true;
        }
    }

    @Override
    public List<Item> findAll() throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT id, name, \"desc\" FROM items")) {
            List<Item> items = new ArrayList<Item>();
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item();
                    item.setId(resultSet.getString("id"));
                    item.setName(resultSet.getString("name"));
                    item.setDesc(resultSet.getString("desc"));
                    items.add(item);
                }
                return items;
            }
        }
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT id, name, \"desc\" FROM items WHERE name = ?")) {
            List<Item> items = new ArrayList<Item>();
            stmt.setString(1, key);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getString("id"));
                item.setName(resultSet.getString("name"));
                item.setDesc(resultSet.getString("desc"));
                items.add(item);
            }
            return items;
        }
    }

    @Override
    public Item findById(String id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT name, \"desc\" FROM items WHERE id = ?")) {
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Item item = new Item();
                item.setId(id);
                item.setName(resultSet.getString(1));
                item.setDesc(resultSet.getString(2));
                return item;
            }
            return null;
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
