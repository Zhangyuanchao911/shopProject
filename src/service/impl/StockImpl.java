package service.impl;

import dao.ProductDao;
import dao.StockDao;
import model.Product;
import model.Stock;
import service.StockService;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class StockImpl implements StockService {
    @Override
    public int add(String bar_code, int count) {
        int flag=0;
        String sql="insert into biz_stock(product_bar_code,stock_count,creat_time,update_time,deleted,lock_key) value(?,?,?,?,?,?)";
        try {
            flag=dao.update(sql,Stock.class,bar_code,count,new Date(),new Date(),0,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;
    }

    @Override
    public Stock findByBarCode(String bar_code) {
        String sql="select * from biz_stock where product_bar_code=? and deleted=0";

        return null;
    }

    @Override
    public List<Product> show() {
        List<Product> products=null;
        ProductDao productDao=new ProductDao(conn);
        String sql="SELECT\n" +
                "\tp.*,\n" +
                "\tc.category_name,\n" +
                "\ts.supplier_name,\n" +
                "\ts.contacts_name,\n" +
                "\ts.tel,\n" +
                "\tstock.stock_count \n" +
                "FROM\n" +
                "\tbiz_product p,\n" +
                "\tbiz_supplier s,\n" +
                "\tbiz_category c,\n" +
                "\tbiz_stock stock \n" +
                "WHERE\n" +
                "\tstock.product_bar_code = p.bar_code \n" +
                "\tAND p.category_id = c.id \n" +
                "\tAND p.supplier_id = s.id \n" +
                "\tAND p.deleted = 0 \n" +
                "\tAND c.deleted = 0 \n" +
                "\tAND stock.deleted =0";
        try {
            products=productDao.listQuery(sql,Product.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> listQueryFuzz(String value) {
        List<Product> products=null;
        ProductDao productDao=new ProductDao(conn);
        String sql="SELECT\n" +
                "\tp.*,\n" +
                "\tc.category_name,\n" +
                "\ts.supplier_name,\n" +
                "\ts.contacts_name,\n" +
                "\ts.tel,\n" +
                "\tstock.stock_count \n" +
                "FROM\n" +
                "\tbiz_product p,\n" +
                "\tbiz_supplier s,\n" +
                "\tbiz_category c,\n" +
                "\tbiz_stock stock \n" +
                "WHERE\n" +
                "\tstock.product_bar_code = p.bar_code \n" +
                "\tAND p.category_id = c.id \n" +
                "\tAND p.supplier_id = s.id \n" +
                "\tAND p.deleted = 0 \n" +
                "\tAND c.deleted = 0 \n" +
                "\tAND stock.deleted =0\n" +
                "\tAND p.product_name like ?";
        try {
            products=productDao.listQuery(sql,Product.class,"%"+value+"%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> showRecord() {
        List<Product> products=null;
        ProductDao productDao=new ProductDao(conn);
        String sql="SELECT\n" +
                "\tp.*,\n" +
                "\tc.category_name,\n" +
                "\ts.supplier_name,\n" +
                "\ts.contacts_name,\n" +
                "\ts.tel,\n" +
                "\tstock.modify_type,\n" +
                "\tstock.modify_count\n" +
                "FROM\n" +
                "\tbiz_product p,\n" +
                "\tbiz_supplier s,\n" +
                "\tbiz_category c,\n" +
                "\tbiz_stock_modify_record stock \n" +
                "WHERE\n" +
                "\tstock.product_bar_code = p.bar_code \n" +
                "\tAND p.category_id = c.id \n" +
                "\tAND p.supplier_id = s.id \n" +
                "\tAND p.deleted = 0 \n" +
                "\tAND c.deleted = 0 \n" +
                "\tAND stock.deleted =0";
        try {
            products=productDao.listQuery(sql,Product.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
    public List<Product> showRecordFuzzy(String value){
        List<Product> products=null;
        ProductDao productDao=new ProductDao(conn);
        String sql="SELECT\n" +
                "\tp.*,\n" +
                "\tc.category_name,\n" +
                "\ts.supplier_name,\n" +
                "\ts.contacts_name,\n" +
                "\ts.tel,\n" +
                "\tstock.modify_type,\n" +
                "\tstock.modify_count\n" +
                "FROM\n" +
                "\tbiz_product p,\n" +
                "\tbiz_supplier s,\n" +
                "\tbiz_category c,\n" +
                "\tbiz_stock_modify_record stock \n" +
                "WHERE\n" +
                "\tstock.product_bar_code = p.bar_code \n" +
                "\tAND p.category_id = c.id \n" +
                "\tAND p.supplier_id = s.id \n" +
                "\tAND p.deleted = 0 \n" +
                "\tAND c.deleted = 0 \n" +
                "\tAND stock.deleted =0\n" +
                "\tAND p.product_name LIKE ?";
        try {
            products=productDao.listQuery(sql,Product.class,"%"+value+"%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    private Connection conn;
    private StockDao dao;
    public StockImpl(){
        conn= JDBCUtil.getInstance().getConnection();
        dao=new StockDao(conn);
    }
}
