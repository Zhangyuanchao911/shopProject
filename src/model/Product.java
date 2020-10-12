package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
public class Product {
    private int id;
    private String bar_code;
    private int supplier_id;
    private String supplier_name;
    private int category_id;
    private String category_name;
    private String product_name;
    private String modify_type;
    private int modify_count;
    public Product(String bar_code, int supplier_id, int category_id, String product_name, float product_price) {
        this.bar_code = bar_code;
        this.supplier_id = supplier_id;
        this.category_id = category_id;
        this.product_name = product_name;
        this.product_price = product_price;
    }

    public String getModify_type() {
        return modify_type;
    }

    public void setModify_type(String modify_type) {
        this.modify_type = modify_type;
    }

    public int getModify_count() {
        return modify_count;
    }

    public void setModify_count(int modify_count) {
        this.modify_count = modify_count;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public BigDecimal getSale_price() {
        return sale_price;
    }

    public void setSale_price(BigDecimal sale_price) {
        this.sale_price = sale_price;
    }

    public Integer getSale_count() {
        return sale_count;
    }

    public void setSale_count(Integer sale_count) {
        this.sale_count = sale_count;
    }

    public Date getSale_date() {
        return sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }

    public List<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(List<Supplier> supplierList) {
        this.supplierList = supplierList;
    }

    public String getBatch_code() {
        return batch_code;
    }

    public void setBatch_code(String batch_code) {
        this.batch_code = batch_code;
    }

    public BigDecimal getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(BigDecimal purchase_price) {
        this.purchase_price = purchase_price;
    }

    private float product_price;
    private Date creat_time;
    private Date update_time;
    private int deleted;
    private String contacts_name;
    private String tel;
    private List<Category> categoryList;
    private BigDecimal sale_price;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private Integer sale_count;
    private Date sale_date;
    private int stock_count;
    private List<Supplier> supplierList;
    private String batch_code;
    private BigDecimal purchase_price;
    private String count;
    private BigDecimal amount;

    private String exp_date;

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public Product(){}

    public String getContacts_name() {
        return contacts_name;
    }

    public void setContacts_name(String contacts_name) {
        this.contacts_name = contacts_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", bar_code='" + bar_code + '\'' +
                ", supplier_id=" + supplier_id +
                ", category_id=" + category_id +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", creat_time=" + creat_time +
                ", update_time=" + update_time +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
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
