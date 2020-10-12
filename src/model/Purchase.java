package model;

import java.math.BigDecimal;
import java.util.Date;


public class Purchase{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getPro_date() {
        return pro_date;
    }

    public void setPro_date(String pro_date) {
        this.pro_date = pro_date;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public BigDecimal getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(BigDecimal purchase_price) {
        this.purchase_price = purchase_price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReceipt_img() {
        return receipt_img;
    }

    public void setReceipt_img(String receipt_img) {
        this.receipt_img = receipt_img;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
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

    private int id;

    /**
     * 商品条形码
     */
    private int product_id;

    /**
     * 采购日期
     */
    private String purchase_date;


    /**
     * 生产日期
     */
    private String pro_date;

    /**
     * 保质期
     */
    private String exp_date;

    /**
     * 进货单价
     */
    private BigDecimal purchase_price;



    private int count;

    private BigDecimal amount;

    private String receipt_img;

    private Date create_time;

    private Date update_time;

    private int deleted;


}
