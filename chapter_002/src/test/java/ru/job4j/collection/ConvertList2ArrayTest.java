package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenListArraysThenListInt() {
        List<int[]> list = new ArrayList();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        ConvertList2Array conv = new ConvertList2Array();
        List<Integer> result = conv.convert(list);
        List<Integer> etalon = new ArrayList<>();
        etalon.add(1);
        etalon.add(2);
        etalon.add(3);
        etalon.add(4);
        etalon.add(5);
        etalon.add(6);
        assertThat(result, is(etalon));
    }
}
