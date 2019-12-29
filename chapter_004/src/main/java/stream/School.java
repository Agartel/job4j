package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public final List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> res = students.stream().filter(predict).collect(Collectors.toList());
        return res;
    }
}
