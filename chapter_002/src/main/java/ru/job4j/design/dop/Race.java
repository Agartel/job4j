package ru.job4j.design.dop;

public abstract class Race {
    private int hp = 100;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }
}
