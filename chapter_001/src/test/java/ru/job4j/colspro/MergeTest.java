package ru.job4j.colspro;

import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MergeTest {

    @Test
    public void whenFiveUsersIsAllThen2Uniq() {
        User u1 = new User("User1");
        u1.addEmail("xxx@ya.ru");
        u1.addEmail("foo@gmail.com");
        u1.addEmail("lol@mail.ru");
        User u2 = new User("User2");
        u2.addEmail("foo@gmail.com");
        u2.addEmail("ups@pisem.net");
        User u3 = new User("User3");
        u3.addEmail("xyz@pisem.net");
        u3.addEmail("vasya@pupkin.com");
        User u4 = new User("User4");
        u4.addEmail("ups@pisem.net");
        u4.addEmail("aaa@bbb.ru");
        User u5 = new User("User5");
        u5.addEmail("xyz@pisem.net");
        List<User> users = new ArrayList<User>(Arrays.asList(u1, u2, u3, u4, u5));
        List<User> res = Merge.mergeUsers(users);
        assertThat(res.get(0).getName(), is("User1"));
        Iterator it = res.get(0).getEmails().iterator();
        assertThat(it.next(), is("aaa@bbb.ru"));
        assertThat(it.next(), is("foo@gmail.com"));
        assertThat(it.next(), is("lol@mail.ru"));
        assertThat(it.next(), is("ups@pisem.net"));
        assertThat(it.next(), is("xxx@ya.ru"));
        assertFalse(it.hasNext());
        assertThat(res.get(1).getName(), is("User3"));
        it = res.get(1).getEmails().iterator();
        assertThat(it.next(), is("vasya@pupkin.com"));
        assertThat(it.next(), is("xyz@pisem.net"));
        assertFalse(it.hasNext());
    }
}