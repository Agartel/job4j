package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        // проверить. что массив word имеет последние элементы одинаковые с post
        boolean result = false;
        for (int i = 0; i < post.length; i++) {
            if (word[(word.length - post.length) + i] != post[i]) {
                break;
            }
            if (i == post.length - 1) {
                result = true;
            }
        }
        return result;
    }
}
