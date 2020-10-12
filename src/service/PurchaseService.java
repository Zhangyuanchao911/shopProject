package service;

import model.Product;
import model.Purchase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PurchaseService {
    int insert(int productId, String purchaseDate, String proDate, String expDate, BigDecimal purchasePrice,
               int purchaseCount, BigDecimal purchaseAmount);
    List<Product> show();
    List<Product> fuzzyQuery(String value);
    boolean purchase(String barCode, int userId,String productName, BigDecimal purchasePrice, String purchaseDate, String proDate,
                 String expDate, int purchaseCount, BigDecimal salePrice, int supplierId, int categoryId);
}
