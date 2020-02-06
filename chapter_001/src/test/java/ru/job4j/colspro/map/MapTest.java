package ru.job4j.colspro.map;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return children == user.children &&
                    Objects.equals(name, user.name) &&
                    Objects.equals(birthday, user.birthday);
        }

        @Override
        public int hashCode() {
            int hash = name == null ? 0 : name.hashCode();
            hash = 31 * hash + (birthday == null ? 0 : birthday.hashCode()) + children;
            return hash;
        }
    }

    @Test
    public void Map () {
        Calendar date = Calendar.getInstance();
        User user1 = new User("Alex", 0,date);
        User user2 = new User("Alex2", 0,date);
        Set<User> set = new HashSet<>();
        set.add(user1);
        set.add(user2);
        System.out.println(set);
    }
}
