package ru.job4j.io;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "../chapter_002/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.password"),
                is("password")
        );
    }
    @Test
    public void whenPairWithComment() {
        String path = "../chapter_002/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.password"),
                is("password")
        );
    }
}