package ru.job4j.strean;

import org.junit.Assert;
import org.junit.Test;
import stream.School;
import stream.Student;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SchoolTest {
    @Test
    public void whenFilterStudentsLess50ThenGiveGroupC() {
        School school = new School();
        List<Student> studs = Arrays.asList(new Student(12),
                new Student(35),
                new Student(56),
                new Student(69),
                new Student(70),
                new Student(99));

        List<Student> studsA = school.collect(studs, Student -> Student.getScore() < 50);
        boolean res = false;
        if (studsA.get(0).getScore() == 12 && studsA.get(1).getScore() == 35) {
            res = true;
        }
        assertTrue(res);
    }

    @Test
    public void whenFilterStudentsBigger50AndLess70ThenGiveGroupB() {
        School school = new School();
        List<Student> studs = Arrays.asList(new Student(12),
                new Student(35),
                new Student(56),
                new Student(69),
                new Student(70),
                new Student(99));

        List<Student> studsA = school.collect(studs, Student -> Student.getScore() >= 50 && Student.getScore() < 70);
        boolean res = false;
        if (studsA.get(0).getScore() == 56 && studsA.get(1).getScore() == 69) {
            res = true;
        }
        assertTrue(res);
    }

    @Test
    public void whenFilterStudentsBigger70ThenGiveGroupA() {
        School school = new School();
        List<Student> studs = Arrays.asList(new Student(12),
                new Student(35),
                new Student(56),
                new Student(69),
                new Student(70),
                new Student(99));

        List<Student> studsA = school.collect(studs, Student -> Student.getScore() >= 70);
        boolean res = false;
        if (studsA.get(0).getScore() == 70 && studsA.get(1).getScore() == 99) {
            res = true;
        }
        assertTrue(res);
    }
}
