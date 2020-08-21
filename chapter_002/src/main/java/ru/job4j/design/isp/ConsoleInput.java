package ru.job4j.design.isp;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input, ExtendInput {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int[] askArray(String question) {
        String[] result = askStr(question).split("\\.");
        int[] askArray = new int[result.length];
        for (int i = 0; i < result.length; i++) {
          askArray[i] = Integer.parseInt(result[i]);
        }
        if (askArray.length == 0) {
            throw new IllegalStateException();
        }
        return askArray;
    }
}
