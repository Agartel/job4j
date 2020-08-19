package ru.job4j.design.lsp;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Food {
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime expireDate;
    private Integer price;
    private Integer disscount;

    public Food(String name, LocalDateTime createDate, LocalDateTime expireDate, Integer price, Integer disscount) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.disscount = disscount;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDisscount(Integer disscount) {
        this.disscount = disscount;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getDisscount() {
        return disscount;
    }
}
