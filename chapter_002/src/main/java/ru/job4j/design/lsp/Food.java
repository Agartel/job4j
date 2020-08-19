package ru.job4j.design.lsp;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Food {
    private String mame;
    private LocalDateTime createDate;
    private LocalDateTime expireDate;
    private Integer price;
    private Integer disscount;

    public Food(String mame, LocalDateTime createDate, LocalDateTime expireDate, Integer price, Integer disscount) {
        this.mame = mame;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.disscount = disscount;
    }

    public void setMame(String mame) {
        this.mame = mame;
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

    public String getMame() {
        return mame;
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
