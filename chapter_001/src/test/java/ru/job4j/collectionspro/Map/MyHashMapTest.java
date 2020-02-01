package ru.job4j.collectionspro.Map;

import org.junit.Test;
import ru.job4j.collectionspro.Set.SimpleSet;

import java.util.Calendar;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyHashMapTest {
    @Test
    public void whenAdd() {
        Calendar date = Calendar.getInstance();
        MapTest.User user1 = new MapTest.User("alex", 2, date);
        MapTest.User user2 = new MapTest.User("alex2", 2, date);
        MyHashMap<MapTest.User, Integer> mymap = new MyHashMap();
        mymap.insert(user1, 5);
        mymap.insert(user2, 8);
        int x = mymap.next();
        x = mymap.next();
        x = mymap.next();
    }
}