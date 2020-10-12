package service;

import model.Category;

import java.util.Date;
import java.util.List;

public interface CategoryService {
    List<Category> listQuery();
    List<Category> listFuzzy(String value);
    int delete(int id);
    int update(String category_name,int id);
    int add(Category category);
    Category query(int id);
}
