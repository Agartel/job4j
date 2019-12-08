package ru.job4j.fit;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        float in = 174.0f;
        float expected = 85.1f;
        float out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    };
    @Test
    public void womanWeight() {
        float in = 174.0f;
        float expected = 73.6f;
        float out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    };
}
