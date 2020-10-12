package model;

import java.util.Date;

public class StockRecord {
    private int id;
    private String product_bar_code;
    private int operator_id;
    private int modify_count;
    private String modify_type;
    private Date update_time;
    private Date creat_time;
    private int deleted;

    public String getModify_type() {
        return modify_type;
    }

    public void setModify_type(String modify_type) {
        this.modify_type = modify_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_bar_code() {
        return product_bar_code;
    }

    public void setProduct_bar_code(String product_bar_code) {
        this.product_bar_code = product_bar_code;
    }

    public int getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
    }

    public int getModify_count() {
        return modify_count;
    }

    public void setModify_count(int modify_count) {
        this.modify_count = modify_count;
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
