package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.Converter;

public class ConverterTest {

    @Test
    public void rubleToEuro() {
        int in = 140;
        float expected = 2;
        float out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out, 0);
    };

    @Test
    public void rubleToDollar() {
        int in = 180;
        float expected = 3;
        float out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out, 0);
    };

    @Test
    public void dollarToRuble() {
        int in = 1;
        float expected = 60;
        float out = Converter.dollarToRuble(in);
        Assert.assertEquals(expected, out, 0);
    };

    @Test
    public void euroToRuble() {
        int in = 5;
        float expected = 350;
        float out = Converter.euroToRuble(in);
        Assert.assertEquals(expected, out, 0);
    };
}
