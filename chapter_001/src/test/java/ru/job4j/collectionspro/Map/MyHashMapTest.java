package ru.job4j.collectionspro.Map;

import org.junit.Test;
import ru.job4j.collectionspro.Set.SimpleSet;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyHashMapTest {
    @Test(expected = NoSuchElementException.class)
    public void whenAddsUsersAndDeleteOneOfAllUserThenGetCorretUsers() {
        Calendar date = Calendar.getInstance();
        MapTest.User user1 = new MapTest.User("alex", 2, date);
        MapTest.User user2 = new MapTest.User("alex2", 2, date);
        MapTest.User user3 = new MapTest.User("alex3", 2, date);
        MapTest.User user4 = new MapTest.User("alex4", 2, date);
        MyHashMap<MapTest.User, Integer> mymap = new MyHashMap();
        mymap.insert(user1, 5);
        mymap.insert(user2, 8);
        mymap.insert(user3, 9);
        mymap.insert(user4, 2);
        mymap.delete(user2);
        assertThat(mymap.get(user1), is(5));
        assertThat(mymap.get(user3), is(9));
        assertThat(mymap.get(user4), is(2));
        mymap.get(user2);
    }

    @Test
    public void whenAdd3UniqObjectThenGet3ObjectViaIterator() {
        Calendar date = Calendar.getInstance();
        MapTest.User user1 = new MapTest.User("alex", 2, date);
        MapTest.User user2 = new MapTest.User("alex2", 2, date);
        MapTest.User user3 = new MapTest.User("alex3", 2, date);
        MyHashMap<MapTest.User, Integer> mymap = new MyHashMap();
        mymap.insert(user1, 5);
        mymap.insert(user2, 8);
        mymap.insert(user3, 9);
        Iterator<Integer> it =mymap.iterator();
        it.next();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void whenAddObjectsThenGetOnlyUniq() {
        Calendar date = Calendar.getInstance();
        MapTest.User user1 = new MapTest.User("alex", 2, date);
        MapTest.User user2 = new MapTest.User("alex", 2, date);
        MyHashMap<MapTest.User, Integer> mymap = new MyHashMap();
        mymap.insert(user1, 5);
        mymap.insert(user2, 8);
        Iterator<Integer> it =mymap.iterator();
        assertThat(it.next(), is(5));
        assertFalse(it.hasNext());
    }
}