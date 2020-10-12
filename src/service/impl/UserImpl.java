package service.impl;

import dao.UserDao;
import model.User;
import service.UserService;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserImpl implements UserService {
    @Override
    public User login(String username, String password){
        String sql="select * from sys_user where login_account=? and password=? and deleted=0";
        User user=null;
        try {
             user= userdao.queryOne(sql,User.class,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> listQuery() {
        List<User> list=null;
        String sql="select u.*,r.role_name from sys_user u,sys_role r where u.deleted=0 AND u.role_id=r.id";
        try {
            list= userdao.listQuery(sql,User.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(User user) {
        int count=0;
        String sql="insert into sys_user(user_name,role_id,login_account,password,tel,wx_account,id_no,address,creat_time,update_time,deleted) value(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            count=userdao.update(sql,User.class,user.getUser_name(),user.getRole_id(),user.getLogin_account(),user.getPassword(),user.getTel(),user.getWx_account()
            ,user.getId_no(),user.getAddress(),new Date(),new Date(),0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(User user) {
        int count=0;
        String sql="update sys_user set user_name=?,role_id=?,login_account=?,password=?,tel=?,wx_account=?,id_no=?,address=?,update_time=? where id=?";
        try {
            count=userdao.update(sql,User.class,user.getUser_name(),user.getRole_id(),user.getLogin_account(),user.getPassword(),user.getTel(),user.getWx_account(),user.getId_no(),
                    user.getAddress(),new Date(),user.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int delete(int id) {
        int count=0;
        String sql="update sys_user set deleted=1 where id=?";
        try {
            count=userdao.update(sql,User.class,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  count;
    }

    @Override
    public User query(int id) {
        User user=null;
        String sql="select u.*,r.role_name from sys_user u,sys_role r where u.deleted=0 AND u.role_id=r.id AND u.id=?";
        try {
            user=userdao.queryOne(sql,User.class,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> listQueryFuzz(String value) {
        List<User> user=new ArrayList<>();
        String sql="select u.*,r.role_name from sys_user u,sys_role r where u.user_name like ? and u.deleted=0 AND u.role_id=r.id";
        try {
            user=userdao.listQuery(sql,User.class,"%"+value+"%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public UserImpl(){
        conn= JDBCUtil.getInstance().getConnection();
        userdao=new UserDao(conn);
    }
    private Connection conn;
    private UserDao userdao;
}
