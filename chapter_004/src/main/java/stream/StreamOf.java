package stream;

import java.util.*;

public class StreamOf {
    public static void main(String[] args) {
        List.of(5, 1, 2).forEach(System.out::println);

        Set.of(5, 1, 2).forEach(System.out::println);

        Map.of("first", 1, "second", 2)
                .forEach((v, k) -> System.out.println(String.format("%s %s", v, k)));
    }
}
