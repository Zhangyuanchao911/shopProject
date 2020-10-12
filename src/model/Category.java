package model;

import java.util.Date;


public class  Category {
     private int id;
     private String category_name;
     private Date creat_time;
     private Date update_time;
     private int deleted;

    public Category() {
    }
    public Category(String category_name, Date creat_time, Date update_time, int deleted) {
        this.category_name = category_name;
        this.creat_time = creat_time;
        this.update_time = update_time;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
