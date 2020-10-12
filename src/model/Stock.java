package model;

import java.util.Date;

public class Stock {
    private String bar_code;
    private String stock_count;
    private Date update_time;
    private Date creat_time;
    private int deleted;
    private String lock_key;

    public Stock() {
    }

    public String getLock_key() {
        return lock_key;
    }

    public void setLock_key(String lock_key) {
        this.lock_key = lock_key;
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public String getStock_count() {
        return stock_count;
    }

    public void setStock_count(String stock_count) {
        this.stock_count = stock_count;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
