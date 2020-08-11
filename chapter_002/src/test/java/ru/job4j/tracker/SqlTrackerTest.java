package ru.job4j.tracker;

import com.sun.source.tree.AssertTree;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    private PreparedStatement stmt;

    public Connection init() {
        return new DefaultDBFactory().getConnect("tracker_db.properties");
    }

    public String getRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    @Test
    public void addTest() throws SQLException {
        SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("qqq");
        sqlTracker.add(item);
        Connection testconn = this.init();
        this.stmt = testconn.prepareStatement("SELECT name FROM items WHERE ID = ?");
        this.stmt.setInt(1, Integer.parseInt(item.getId()));
        this.stmt.executeQuery();
        ResultSet resultSet = stmt.getResultSet();
        String name = resultSet.next() ? resultSet.getString("name") : null;
        assertThat(item.getName(), is(name));
    }

    @Test
    public void findByIdTest() throws SQLException {
        SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("qqq");
        sqlTracker.add(item);
        Item itemtmp = sqlTracker.findById(item.getId());
        assertThat(item.getName(), is(itemtmp.getName()));
    }

    @Test
    public void replaceTest() throws SQLException {
        SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("qqq");
        sqlTracker.add(item);
        Item item2 = new Item("yyy");
        Boolean isUpdateSuccess = sqlTracker.replace(item.getId(), item2);
        Item item3 = sqlTracker.findById(item.getId());
        assertTrue(isUpdateSuccess);
        assertThat(item3.getName(), is(item2.getName()));
        assertThat(item3.getId(), is(item.getId()));
    }

    @Test
    public void deleteTest() throws SQLException {
        SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("qqq");
        sqlTracker.add(item);
        Boolean isDeleteSuccess = sqlTracker.delete(item.getId());
        Item item2 = sqlTracker.findById(item.getId());
        assertTrue(isDeleteSuccess);
        assertNull(item2);
    }

    @Test
    public void findAllTest() throws SQLException {
        SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        List<Item> items = sqlTracker.findAll();
        Connection testconn = this.init();
        this.stmt = testconn.prepareStatement("SELECT id, name FROM items");
        this.stmt.executeQuery();
        ResultSet resultSet = stmt.getResultSet();
        List<Item> items2 = new ArrayList<Item>();
        while (resultSet.next()) {
            Item item = new Item();
            item.setName(resultSet.getString("id"));
            item.setName(resultSet.getString("name"));
            items2.add(item);
        }
        assertThat(items.size(), is(items2.size()));
    }

    @Test
    public void findByNameTest() throws SQLException {
        SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        String name = getRandomString();
        Item item = new Item(name);
        sqlTracker.add(item);
        item = new Item(name);
        sqlTracker.add(item);
        List<Item> items = sqlTracker.findByName(name);
        Connection testconn = this.init();
        this.stmt = testconn.prepareStatement("SELECT id, name FROM items WHERE name = ?");
        this.stmt.setString(1, name);
        this.stmt.executeQuery();
        ResultSet resultSet = stmt.getResultSet();
        List<Item> items2 = new ArrayList<Item>();
        while (resultSet.next()) {
            item = new Item();
            item.setName(resultSet.getString("id"));
            item.setName(resultSet.getString("name"));
            items2.add(item);
        }
        assertThat(items.size(), is(items2.size()));
    }

    @Test
    public void closeSuccessTest() throws Exception {
        SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        sqlTracker.init();
        sqlTracker.close();
    }

    @Test
    public void closeFailTest() throws Exception {
        SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        sqlTracker.close();
    }

    @Test
    public void whenConnectionRollbackEnableThenOneRow() throws Exception {
        SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        sqlTracker.add(new Item("nadia", "pokalykhina"));
        sqlTracker.close();
        sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        sqlTracker.add(new Item("nadia", "pokalykhina"));
        assertThat(sqlTracker.findByName("nadia").size(), is(1));
    }

    @Test
    public void whenConnectionRollbackDisableThenManyRows() throws Exception {
        SqlTracker sqlTracker = new SqlTracker(this.init());
        for (Item item : sqlTracker.findByName("alex")) {
            sqlTracker.delete(item.getId());
        }
        sqlTracker.add(new Item("alex", "gartel"));
        sqlTracker.close();
        sqlTracker = new SqlTracker(this.init());
        sqlTracker.add(new Item("alex", "gartel"));
        assertTrue(sqlTracker.findByName("alex").size() > 1);
    }
}
