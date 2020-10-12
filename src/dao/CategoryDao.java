package dao;

import model.Category;

import java.sql.Connection;

public class CategoryDao extends BasicDao<Category> {
    public CategoryDao(Connection conn) {
        super(conn);
    }
}
