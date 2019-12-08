package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.fit.Fit;

public class PointTest {

    @Test
    public void distance() {
        int in1 = 5;
        int in2 = 6;
        int in3 = 8;
        int in4 = 9;
        double expected = 4.24264;
        double out = Point.distance(in1, in2, in3, in4);
        Assert.assertEquals(expected, out, 0.01); //0.0_000_001
    };
}
