package model;

import java.util.Date;

public class Supplier {
    private int id;
    private String supplier_name;
    private String contacts_name;
    private String address;
    private String tel;
    private Date creat_time;
    private Date update_time;
    private int deleted;

    public Supplier() {
    }
    public Supplier(String supplier_name, String contacts_name, String address, String tel, Date creat_time, Date update_time, int deleted) {
        this.supplier_name = supplier_name;
        this.contacts_name = contacts_name;
        this.address = address;
        this.tel = tel;
        this.creat_time = creat_time;
        this.update_time = update_time;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supplier_name='" + supplier_name + '\'' +
                ", contacts_name='" + contacts_name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
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

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getContacts_name() {
        return contacts_name;
    }

    public void setContacts_name(String contacts_name) {
        this.contacts_name = contacts_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
