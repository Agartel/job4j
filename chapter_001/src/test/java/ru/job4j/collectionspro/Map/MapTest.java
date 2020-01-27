package ru.job4j.collectionspro.Map;

import org.junit.Test;

import java.util.*;

public class MapTest {
    public final static class User {
        String name;
        int children;
        Calendar birthday;

        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }
    }

    @Test
    public void Map () {
        Calendar date = Calendar.getInstance();
        User user1 = new User("Alex", 0,date);
        User user2 = new User("Alex", 0,date);
        Set<User> set = new HashSet<>();
        set.add(user1);
        set.add(user2);
        System.out.println(set);
    }
}
