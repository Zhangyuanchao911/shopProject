package service.impl;

import dao.RoleDao;
import model.Role;
import service.RoleService;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleImpl implements RoleService {
    private Connection conn;
    private RoleDao dao;
    public RoleImpl(){
        conn= JDBCUtil.getInstance().getConnection();
        dao=new RoleDao(conn);
    }
    @Override
    public List<Role> listQuery() {
        List<Role> list=null;
        String sql="SELECT * FROM sys_role WHERE deleted=0";
        try {
            list=dao.listQuery(sql,Role.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
