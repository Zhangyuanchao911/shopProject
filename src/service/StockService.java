package service;

import model.Product;
import model.Stock;

import java.util.List;

public interface StockService {
     int add(String bar_code,int count);
     Stock findByBarCode(String bar_code);
     List<Product> show();
     List<Product> listQueryFuzz(String value);
     List<Product> showRecord();
     List<Product> showRecordFuzzy(String value);
}
      

