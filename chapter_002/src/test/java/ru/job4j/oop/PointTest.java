package ru.job4j.oop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PointTest {
    @Test
    public void whenP24P42DistanceIs284() {
        Point point1 = new Point(2, 4);
        Point point2 = new Point(4, 2);
        double result = point1.distance(point2);
        assertEquals(result, 2.82, 0.01);
    }
    @Test
    public void whenP55P44DistanceIs316() {
        Point point1 = new Point(2, 4);
        Point point2 = new Point(5, 5);
        double result = point1.distance(point2);
        assertEquals(result, 3.16, 0.01);
    }
    @Test
    public void whenP42P55DistanceIs316() {
        Point point1 = new Point(4, 2);
        Point point2 = new Point(5, 5);
        double result = point1.distance(point2);
        assertEquals(result, 3.16, 0.01);
    }
}
