package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square() {
        int in1 = 6;
        int in2 = 2;
        double expected = 2.88;
        double out = SqArea.square(in1, in2);
        Assert.assertEquals(expected, out, 0.01);
    };
}
