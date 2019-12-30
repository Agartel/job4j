package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
       // Stream<int[]> st = Stream.of(matrix);
        List<Integer> list = Arrays.stream(matrix).flatMapToInt(e -> Arrays.stream(e)).collect(Collectors.toList());
    }
}
