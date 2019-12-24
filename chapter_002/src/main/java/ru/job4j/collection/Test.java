package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Abc {
    int x;
}

class  Xyz {
    int y;
}

public class Test {
    public static void main(String[] args) {
        Abc a = new Abc();
        Map<Abc, List<Xyz>> map = new HashMap<Abc, List<Xyz>>();
        List<Xyz> x = new ArrayList<Xyz>();
        x.add(new Xyz());
        map.put(a, x);
        System.out.println(map.get(a));

    }
}
