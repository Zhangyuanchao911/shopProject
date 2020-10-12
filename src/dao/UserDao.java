package dao;

import model.User;

import java.sql.Connection;
import java.util.List;

public class UserDao extends  BasicDao<User>{
    public UserDao(Connection conn) {
        super(conn);
    }
//    Dao d=new Dao();
//    public void addUser(User user){
//        String sql="insert into sys_user(role_id,user_name,login_account,password,tel,wx_account,id_no,address,creat_time," +
//                "update_time,deleted) values(?,?,?,?,?,?,?,?,?,?,?)";
//        d.update(sql,user.getRole_id(),user.getUser_name(),user.getLogin_account(),user.getPassword(),user.getTel(),user.getWx_account(),
//                user.getId_no(),user.getAddress(),user.getCreat_time(),user.getUpdate_time(),user.getDeleted());
//    }
//    public List<User> select(){
//        String sql="select * from sys_user where deleted=0";
//        List<User> users =d.select(sql,User.class);
//        return users;
//    }
//    public User selectByCount(String login_account,String password){
//        User user=new User();
//        String sql="select * from sys_user where login_account=? and password=? and deleted=0";
//        List<User> list= d.selectByValue(sql,User.class,login_account,password);
//        if (list!=null){
//            user=list.get(0);
//        }
//        return user;
//    }
//    public boolean delete(int id){
//        String sql="update sys_user set deleted=1 where id=?";
//        return d.update(sql,id);
//    }

}
