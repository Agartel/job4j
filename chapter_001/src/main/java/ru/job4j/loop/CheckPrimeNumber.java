package ru.job4j.loop;

public class CheckPrimeNumber {
        public boolean check(int finish) {
            boolean prime = false;
            if (finish != 1) {
                for (int i = 1; i <= finish; i++) {
                    if (finish % i == 0) {
                        if (finish == i) {
                            prime = true;
                        } else if (i != 1) {
                            break;
                        }
                    }
                }
            }
            return prime;
    }
}
