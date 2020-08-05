package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;
    private PreparedStatement stmt;

    public void init() {
        DBFactory factory = new DefaultDBFactory();
        connection = factory.getConnect("postgress_db.properties");
    }

    @Override
    public Item add(Item item) throws SQLException {
        this.stmt = this.connection.prepareStatement("INSERT INTO items (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        this.stmt.setString(1, item.getName());
        this.stmt.executeUpdate();
        ResultSet genKey = this.stmt.getGeneratedKeys();
        if (genKey.next()) {
           item.setId(genKey.getString(1));
           return item;
        }
        return null;
    }

    @Override
    public boolean replace(String id, Item item) throws SQLException {
        this.stmt = this.connection.prepareStatement("UPDATE items SET name = ? WHERE ID = ?");
        this.stmt.setString(1, item.getName());
        this.stmt.setInt(2, Integer.parseInt(id));
        this.stmt.executeUpdate();
        int count = this.stmt.getUpdateCount();
        if (count == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        this.stmt = this.connection.prepareStatement("DELETE FROM items WHERE ID = ?");
        this.stmt.setInt(1, Integer.parseInt(id));
        this.stmt.executeUpdate();
        int count = this.stmt.getUpdateCount();
        if (count == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> items = new ArrayList<Item>();
        this.stmt = this.connection.prepareStatement("SELECT id, name FROM items");
        this.stmt.executeQuery();
        ResultSet resultSet = stmt.getResultSet();
        while (resultSet.next()) {
            Item item = new Item();
            item.setName(resultSet.getString("id"));
            item.setName(resultSet.getString("name"));
            items.add(item);
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> items = new ArrayList<Item>();
        this.stmt = this.connection.prepareStatement("SELECT id, name FROM items WHERE name = ?");
        this.stmt.setString(1, key);
        this.stmt.executeQuery();
        ResultSet resultSet = stmt.getResultSet();
        while (resultSet.next()) {
            Item item = new Item();
            item.setName(resultSet.getString("id"));
            item.setName(resultSet.getString("name"));
            items.add(item);
        }
        return items;
    }

    @Override
    public Item findById(String id) throws SQLException {
        this.stmt = this.connection.prepareStatement("SELECT name FROM items WHERE id = ?");
        this.stmt.setInt(1, Integer.parseInt(id));
        this.stmt.executeQuery();
        ResultSet resultSet = this.stmt.getResultSet();
        if (resultSet.next()) {
            Item item = new Item();
            item.setId(id);
            item.setName(resultSet.getString(1));
            return item;
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
