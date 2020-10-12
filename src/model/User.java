package model;

import java.util.Date;

public class User {
    private int id;
    private String user_name;
    private int role_id;
    private String login_account;
    private String password;
    private String tel;
    private String wx_account;
    private String id_no;
    private String address;
    private Date creat_time;
    private Date update_time;
    private String role_name;
    private int deleted;

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public User(String user_name, int role_id, String login_account, String password, String tel, String wx_account, String id_no, String address) {
        this.user_name = user_name;
        this.role_id = role_id;
        this.login_account = login_account;
        this.password = password;
        this.tel = tel;
        this.wx_account = wx_account;
        this.id_no = id_no;
        this.address = address;
    }

    public User(int id, String user_name, int role_id, String login_account, String password, String tel, String wx_account, String id_no, String address) {
        this.id = id;
        this.user_name = user_name;
        this.role_id = role_id;
        this.login_account = login_account;
        this.password = password;
        this.tel = tel;
        this.wx_account = wx_account;
        this.id_no = id_no;
        this.address = address;
    }

    public User() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getLogin_account() {
        return login_account;
    }

    public void setLogin_account(String login_account) {
        this.login_account = login_account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWx_account() {
        return wx_account;
    }

    public void setWx_account(String wx_account) {
        this.wx_account = wx_account;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", role_id=" + role_id +
                ", login_account='" + login_account + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", wx_account='" + wx_account + '\'' +
                ", id_no=" + id_no +
                ", address='" + address + '\'' +
                ", creat_time=" + creat_time +
                ", update_time=" + update_time +
                ", deleted=" + deleted +
                '}';
    }
}
