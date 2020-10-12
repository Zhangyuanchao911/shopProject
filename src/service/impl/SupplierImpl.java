package service.impl;

import dao.SupplierDao;
import model.Supplier;
import service.SupplierService;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SupplierImpl implements SupplierService {
    private Connection conn;
    private SupplierDao dao;
    public SupplierImpl(){
        conn= JDBCUtil.getInstance().getConnection();
        dao=new SupplierDao(conn);
    }
    @Override
    public int add(Supplier supplier) {
        int count=0;
        String sql="insert into biz_supplier (supplier_name,contacts_name,address,tel,creat_time,update_time,deleted) value(?,?,?,?,?,?,0)";
        try {
            count=dao.update(sql,Supplier.class,supplier.getSupplier_name(),supplier.getContacts_name(),supplier.getAddress(),supplier.getTel(),supplier.getCreat_time(),
                    supplier.getCreat_time());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int delete(int id) {
        int count=0;
        String sql="update biz_supplier set deleted=1 where id=?";
        try {
            count=dao.update(sql,Supplier.class,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(Supplier s) {
        int count=0;
        String sql="update biz_supplier set supplier_name=?,contacts_name=?,address=?,tel=?,update_time=?";
        try {
            count=dao.update(sql,Supplier.class,s.getSupplier_name(),s.getContacts_name(),s.getAddress(),s.getTel(),s.getUpdate_time());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Supplier> listQuery() {
        List<Supplier> list=null;
        String sql="select * from biz_supplier where deleted=0";
        try {
            list=dao.listQuery(sql,Supplier.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Supplier query() {
        return null;
    }
}
