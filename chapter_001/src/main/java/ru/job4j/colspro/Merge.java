package ru.job4j.colspro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Merge {
    public static List<User> mergeUsers(List<User> users) {
        List<User> res = new ArrayList<User>();
        res.add(users.get(0));
        for (int i = 1; i < users.size(); i++) {
            boolean isIntersect = false;
            for (int j = 0; j < res.size(); j++) {
                if (!Collections.disjoint(users.get(i).getEmails(), res.get(j).getEmails())) {
                    res.get(j).addEmails(users.get(i).getEmails());
                    isIntersect = true;
                    break;
                }
            }
            if (!isIntersect) {
                res.add(users.get(i));
            }
        }
        return res;
    }
}
