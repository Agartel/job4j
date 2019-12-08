package ru.job4j.fit;

public class Fit {
    public static float manWeight(float height) {
        return  (height - 100.0f) * 1.15f;
    }


    public static float womanWeight(float height) {
        return (height - 110.0f) * 1.15f;
    }

    public static void main(String[] args) {
        float hman = 174.0f;
        float wman = manWeight(hman);
        System.out.println("Man " + Float.toString(hman) + " is " + wman);
        float hwoman = 174.0f;
        float wwoman = womanWeight(hwoman);
        System.out.println("Man " + Float.toString(hwoman) + " is " + wwoman);
    }
}
