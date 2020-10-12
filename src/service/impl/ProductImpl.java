package service.impl;

import dao.ProductDao;
import model.Product;
import service.ProductService;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProductImpl implements ProductService{
    private Connection conn;
    private ProductDao dao;
    public ProductImpl(){
        conn= JDBCUtil.getInstance().getConnection();
        dao=new ProductDao(conn);
    }

    @Override
    public List<Product> listQuery() {
        List<Product> list=null;
        String sql="select * from biz_product where deleted=0 ";
        try {
            list=dao.listQuery(sql,Product.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(Product product) {
        int count=0;
        String sql = "insert into biz_product(bar_code,supplier_id,category_id,product_name,product_price,creat_time,update_time,deleted) " +
                "value(?,?,?,?,?,?,?,0)";
        try {
            count=dao.update(sql,Product.class,product.getBar_code(), product.getSupplier_id(), product.getCategory_id(), product.getProduct_name(), product.getProduct_price()
                    , new Date(), new Date());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int delete(int id) {
        int count=0;
        String sql="update biz_product set deleted=1 where id=?";
        try {
            count=dao.update(sql,Product.class,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(Product product) {
        int count=0;
        String sql="update biz_product set bar_code=?,supplier_id=?" +
                ",category_id=?,product_name=?,product_price=?,update_time=? where id=?" ;
        try {
           count= dao.update(sql,Product.class,product.getBar_code(),product.getSupplier_id(),product.getCategory_id(),product.getProduct_name(),
                   product.getProduct_price(),new Date(),product.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Product> listQueryFuzz(String value) {
        List<Product> list=null;
        String sql="SELECT p.*,c.category_name,s.supplier_name FROM biz_product AS p,biz_category AS c,biz_supplier AS s " +
                "WHERE p.deleted=0 AND p.category_id=c.id AND p.supplier_id=s.id AND p.product_name like ?";
        try {
            list=dao.listQuery(sql,Product.class,"%"+value+"%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> showProduct() {
        List<Product> list=null;
        String sql="SELECT p.*,c.category_name,s.supplier_name FROM biz_product AS p,biz_category AS c,biz_supplier AS s " +
                "WHERE p.deleted=0 AND p.category_id=c.id AND p.supplier_id=s.id";
        try {
            list=dao.listQuery(sql,Product.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Product query(int id) {
        Product product=null;
        String sql="select * from biz_product where id=? and deleted=0";
        try {
             product=dao.queryOne(sql,Product.class,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public Product findByBarCode(String barCode) {
        String sql = "SELECT\n" +
                "\t*\n" +
                "FROM\n" +
                "\tbiz_product\n" +
                "WHERE\n" +
                "\tbar_code =?\n" +
                "AND deleted = 0";
        Product product = null;
        try {
            product = dao.queryOne(sql,Product.class,barCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
