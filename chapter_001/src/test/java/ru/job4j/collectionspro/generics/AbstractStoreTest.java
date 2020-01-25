package ru.job4j.collectionspro.generics;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class AbstractStoreTest {

    @Test
    public void addUserHaveToWork () {
        User user1 = new User("1");
        UserStore<User> us = new UserStore<User>();
        us.add(user1);
        Assert.assertEquals(us.findById("1"), user1);
    }

    @Test
    public void addRoleHaveToWork () {
        Role role1 = new Role("1");
        RoleStore<Role> rs = new RoleStore<Role>();
        rs.add(role1);
        Assert.assertEquals(rs.findById("1"), role1);
    }

    @Test
    public void whenDeleteUser1ThenNotFoundUser1 () {
        User user1 = new User("1");
        UserStore<User> us = new UserStore<User>();
        us.add(user1);
        us.delete("1");
        Assert.assertNull(us.findById("1"));

    }

    @Test
    public void whenReplaceUser1ToUser2ThenNotFoundUser1AndGetUser2 () {
        User user1 = new User("1");
        UserStore<User> us = new UserStore<User>();
        us.add(user1);
        User user2 = new User("2");
        us.replace("1", user2);
        Assert.assertNull(us.findById("1"));
        Assert.assertEquals(us.findById("2"), user2);
    }

}