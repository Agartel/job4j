package ru.job4j.spammer;

import org.junit.Test;
import ru.job4j.tracker.DefaultDBFactory;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTrackerTest;
import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class ImportDBTest {
    private String text1;
    private String text2;
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

    private String createFile() throws IOException {
        this.text1 = getRandomString() + ";" + getRandomString() + ";";
        this.text2 = getRandomString() + ";" + getRandomString() + ";";
        File file = new File("ImportDBTest_loadSuccess.txt");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write(text1);
        bufferWriter.write("\n");
        bufferWriter.write(text2);
        bufferWriter.close();
        return file.getPath();
    }
    @Test
    public void loadSuccess() throws IOException {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, createFile());
        List<ImportDB.User> users =  db.load();
        assertThat(users.get(0).name, is(text1.split(";")[0]));
        assertThat(users.get(0).email, is(text1.split(";")[1]));
        assertThat(users.get(1).name, is(text2.split(";")[0]));
        assertThat(users.get(1).email, is(text2.split(";")[1]));
        assertThat(users.size(), is(2));
    }

    @Test
    public void saveSsuccess() throws IOException, SQLException, ClassNotFoundException {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, createFile());
        List<ImportDB.User> users =  db.load();
        db.save(users);
        try (Connection connection = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            PreparedStatement stmt = connection.prepareStatement("SELECT name FROM users WHERE name = ? and email = ? UNION ALL SELECT name FROM users WHERE name = ? and email = ?");
            stmt.setString(1, text1.split(";")[0]);
            stmt.setString(2, text1.split(";")[1]);
            stmt.setString(3, text1.split(";")[0]);
            stmt.setString(4, text1.split(";")[1]);
            stmt.executeQuery();
            ResultSet resultSet = stmt.getResultSet();
            int i = 0;
            while (resultSet.next()) {
                i++;
            }
            assertThat(i, is(2));
        }
    }
}