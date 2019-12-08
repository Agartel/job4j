package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String result = "Неизвестное слово." + eng;
        return  result;
    }
    public static void main(String[] args) {
        DummyDic dummy = new DummyDic();
        String result = dummy.engToRus("done");
        System.out.println(result);
    }
}
