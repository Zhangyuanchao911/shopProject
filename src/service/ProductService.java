package service;

import model.Product;

import java.util.List;

public interface ProductService {
     List<Product> listQuery();
     int add(Product product);
     int delete(int id);
     int update(Product product);
     List<Product> listQueryFuzz(String value);
     List<Product> showProduct();
     Product query(int id);
     Product findByBarCode(String barCode);
}
