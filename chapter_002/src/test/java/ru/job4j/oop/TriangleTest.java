package ru.job4j.oop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

public class TriangleTest {
    @Test
    public void whenDist316d316d282PeriodIs457() {
        Triangle triangle = new Triangle();
        double result = triangle.period(3.16, 3.16, 2.82);
        assertEquals(result,4.57,0.01);
    }

    @Test
    public void whenCoord22d42d55AreaIs2() {
        Triangle triangle = new Triangle();
        double result = triangle.area(2,2,4,2,5,5);
        assertEquals(result,2.99,0.01);
    }
}
