package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static void main(String[] args) {
         Integer[][] matrix = {{1, 2}, {3, 4}};
         List<Integer> list = Arrays.stream(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }
}
