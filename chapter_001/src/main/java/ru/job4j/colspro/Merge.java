package ru.job4j.colspro;

import ru.job4j.colspro.list.DynamicLinkedArray;

import java.util.*;

public class Merge {

    private static Map<String, Set<String>> getNeighbors(List<User> users) {
        Map<String, Set<String>> listNeighbors = new HashMap<String, Set<String>>();
        for (int i = 0; i < users.size(); i++) {
            for (String email : users.get(i).getEmails()) {
                Set<String> listmails = listNeighbors.get(email);
                if (listmails == null) {
                    listNeighbors.put(email, new HashSet<>());
                } else {
                    listmails.addAll(users.get(i).getEmails());
                }
            }
        }
        return listNeighbors;
    }

    public static List<User> mergeUsers(List<User> users) {
        ArrayList<User> res = new ArrayList<User>();
        Map<String, Set<String>> listNeighbors = getNeighbors(users);
        Set<String> visited = new LinkedHashSet<String>();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            Stack<String> stackMails = new Stack<String>();
            boolean hasItersect = false;
            for (String email : user.getEmails()) {
                if (visited.contains(email)) {
                  hasItersect = true;
                  break;
                }
                stackMails.push(email);
            }
            if (hasItersect) {
                continue;
            }
            res.add(user);
            while (!stackMails.isEmpty()) {
                String email = stackMails.pop();
                if (!visited.contains(email)) {
                    visited.add(email);
                    user.addEmail(email);
                    for (String e : listNeighbors.get(email)) {
                        stackMails.push(e);
                        user.addEmail(e);
                    }
                }
            }
        }
        return res;
    }
}
