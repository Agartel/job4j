package ru.job4j.loop;

import org.junit.Test;
import ru.job4j.loop.Counter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenCntEvnSum() {
        Counter check = new Counter();
        int result = check.add(1, 10);
        assertThat(result, is(30));
    }
}
