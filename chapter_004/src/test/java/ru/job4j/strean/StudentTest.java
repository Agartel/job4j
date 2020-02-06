package ru.job4j.strean;

import ru.job4j.stream.Student;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StudentTest {
    @Test
    public void whenBound60ThenGiveStudentsBiggerThen60() {
        boolean res = false;
        List<Student> studs = Arrays.asList(new Student("Vadim", 12),
                new Student("Irina", 35),
                new Student("Oleg", 56),
                new Student("Igor", 69),
                new Student("Alex", 70),
                null,
                new Student("Svetlana", 99));

        List<Student> filterStuds = Student.levelOf(studs, 40);
        if (filterStuds.size() == 4) {
            res = true;
        }

        assertTrue(res);
    }
}
