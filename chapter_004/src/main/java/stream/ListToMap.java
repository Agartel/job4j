package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        List<Student> studs = Arrays.asList(new Student("Alex", 5), new Student("Egor", 66), new Student("Irina", 76));
        Map<String, Student>  res =  studs.stream().distinct().collect(Collectors.toMap(s -> s.getName(), s -> s));
        System.out.println(res);
    }
    /*
    System.out.println(
        List.of(1, 1, 2, 2).stream().distinct().collect(
                Collectors.toMap(
                        e -> e,
                        e -> e * e
                ))
);
     */
}
