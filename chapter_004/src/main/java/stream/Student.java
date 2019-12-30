package stream;

public class Student {
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
}
