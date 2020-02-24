package ru.job4j.colspro;

import java.util.HashSet;
import java.util.TreeSet;

public class User {
    private String name;
    private TreeSet<String> emails = new TreeSet<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addEmail(String email) {
        this.emails.add(email);
    }

    public void addEmails(TreeSet<String> emails) {
        this.emails.addAll(emails);
    }

    public TreeSet<String> getEmails() {
        return this.emails;
    }
}
