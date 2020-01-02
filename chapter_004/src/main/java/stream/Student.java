package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name) {
        this.name = name;
    }

    public Student(int score) {
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.score, this.score);
    }
    public static List<Student> levelOf(List<Student> students, int bound) {
        List<Student> res = students.stream().flatMap(Stream::ofNullable).sorted().takeWhile(a -> a.getScore() > bound).collect(Collectors.toList());
        return res;
    }
}
