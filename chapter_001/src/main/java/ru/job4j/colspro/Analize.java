package ru.job4j.colspro;

import java.util.*;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int unchanged = 0;
        Info info = new Info();
        Map<Integer, User> curmap = new HashMap<>();
        for (User u : current) {
            curmap.put(u.id, u);
        }
        for (User user : previous) {
            if (curmap.containsKey(user.id)) {
                if (curmap.get(user.id).equals(user)) {
                    unchanged++;
                } else {
                    info.changed++;
                }
                continue;
            }
            info.deleted++;
        }
        info.added = (current.size() - info.changed - unchanged);
        return info;
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass())  {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

}
