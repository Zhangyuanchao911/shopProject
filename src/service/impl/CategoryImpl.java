package service.impl;

import dao.CategoryDao;
import model.Category;
import service.CategoryService;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CategoryImpl implements CategoryService {
    @Override
    public List<Category> listQuery() {
        List<Category> list=null;
        String sql="select * from biz_category where deleted=0";
        try {
            list=dao.listQuery(sql,Category.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Category> listFuzzy(String value) {
        List<Category> list=null;
        String sql="select * from biz_category where deleted=0 and category_name like ?";
        try {
           list=dao.listQuery(sql,Category.class,"%"+value+"%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int delete(int id) {
        int count=0;
        String sql="update biz_category set deleted=1 where id=?";
        try {
            count=dao.update(sql,Category.class,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(String category_name,int id) {
        int count=0;
        String sql="update biz_category set category_name=?,update_time=? where id=?";
        try {
            conn.setAutoCommit(false);
            count=dao.update(sql,Category.class,category_name,new Date(),id);
            conn.commit();
        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int add(Category category) {
        int count=0;
        String sql="insert into biz_category(category_name,creat_time,update_time,deleted) value(?,?,?,?)";
        try {
            count=dao.update(sql,Category.class,category.getCategory_name(),category.getCreat_time(),category.getCreat_time(),0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public Category query(int id) {
        Category category=null;
        String sql="select * from biz_category where id=?";
        try {
            category=dao.queryOne(sql,Category.class,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    public CategoryImpl(){
        conn= JDBCUtil.getInstance().getConnection();
        dao=new CategoryDao(conn);
    }
    private Connection conn;
    private CategoryDao dao;
}
