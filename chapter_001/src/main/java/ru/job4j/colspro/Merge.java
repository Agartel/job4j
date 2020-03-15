package ru.job4j.colspro;

import ru.job4j.colspro.list.DynamicLinkedArray;

import java.util.*;

public class Merge {

    private static Map<String, ArrayList<User>> getNeighbors(List<User> users) {
        Map<String, ArrayList<User>> listNeighbors = new HashMap<String, ArrayList<User>>();
        for (int i = 0; i < users.size(); i++) {
            for (String email : users.get(i).getEmails()) {
                ArrayList<User> listUsers = listNeighbors.get(email);
                if (listUsers == null) {
                    listNeighbors.put(email, new ArrayList<User>(Arrays.asList(users.get(i))));
                } else {
                    listUsers.add(users.get(i));
                }
            }
        }
        return listNeighbors;
    }

    public static List<User> mergeUsers(List<User> users) {
        ArrayList<User> res = new ArrayList<User>();
        Map<String, ArrayList<User>> listNeighbors = getNeighbors(users);
        Set<User> remainUsers = new LinkedHashSet<User>();
        for (User u : users) {
            remainUsers.add(u);
        }
        while (remainUsers.size() > 0) {
            Iterator<User> it = remainUsers.iterator();
            User user = it.next();
            remainUsers.remove(user);
            res.add(user);
            Set<String> visited = new LinkedHashSet<String>();
            Stack<String> stackMails = new Stack<String>();
            for (String email : user.getEmails()) {
                stackMails.push(email);
            }
            while (!stackMails.isEmpty()) {
                String email = stackMails.pop();
                if (!visited.contains(email)) {
                    visited.add(email);
                    user.addEmail(email);
                    List<User> listUsers = listNeighbors.get(email);
                    for (User usr : listUsers) {
                        if (user != usr || remainUsers.contains(usr)) {
                            remainUsers.remove(usr);
                            for (String e : usr.getEmails()) {
                                stackMails.push(e);
                                user.addEmail(e);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
