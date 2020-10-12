package service.impl;

import dao.ProductDao;
import dao.PurchaseDao;
import dao.StockDao;
import dao.StockRecordDao;
import model.Product;
import model.Purchase;
import model.Stock;
import model.StockRecord;
import service.ProductService;
import service.PurchaseService;
import util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseImpl implements PurchaseService {

    @Override
    public boolean purchase(String barCode, int userId, String productName, BigDecimal purchasePrice, String purchaseDate, String proDate, String expDate, int purchaseCount, BigDecimal salePrice, int supplierId, int categoryId) {
        String modify_type="purchase";
        boolean flag=false;
        ProductDao productDao = new ProductDao(conn);
        StockDao stockDao = new StockDao(conn);
        try {
            //事务设置为手动提交
            conn.setAutoCommit(false);
            //查询商品条码
            String sql1 = "select * from biz_product where bar_code=? and deleted=0";
            Product product = productDao.queryOne(sql1, Product.class, barCode);
            /*
                 当商品条码不存在时 创建商品信息
                 获取产品的id
                 添加库存信息
             */
            //计算进货总金额
            BigDecimal purchaseAmount = purchasePrice.multiply(BigDecimal.valueOf(purchaseCount));
            if (product == null) {
                //创建商品
                String sql2 = "insert into biz_product(bar_code,supplier_id,category_id,product_name,product_price,creat_time,update_time,deleted) value(?,?,?,?,?,?,?,?)";
                productDao.update(sql2, Product.class, barCode, supplierId, categoryId, productName, purchasePrice, new Date(), new Date(), 0);
                //添加成功之后，获取此产品的id
                Product product1 = productDao.queryOne(sql1, Product.class, barCode);
                int productId = product1.getId();
                //添加进货信息
                insert(productId, purchaseDate, proDate, expDate, purchasePrice, purchaseCount, purchaseAmount);
                //添加库存信息
                String sql3 = "insert into biz_stock(product_bar_code,stock_count,creat_time,update_time,deleted,lock_key) value(?,?,?,?,?,?)";
                stockDao.update(sql3, Stock.class, barCode, purchaseCount, new Date(), new Date(), 0, null);
            }
            /*
                 当商品存在
                 修改库存数量
             */
            else {
                String sql4 = "select * from biz_stock where product_bar_code=? and deleted=0";
                Stock stock = stockDao.queryOne(sql4, Stock.class, barCode);
                int oldCount=Integer.parseInt(stock.getStock_count());
                String sql5 = "update biz_stock set stock_count=?,update_time=? where product_bar_code=? and deleted=0";
                stockDao.update(sql5,Stock.class,oldCount+purchaseCount,new Date(),barCode,0);
            }
            //添加库存记录
            StockRecordDao stockRecordDao=new StockRecordDao(conn);
            String sql6="insert into biz_stock_modify_record(product_bar_code,operator_id,modify_count,modify_type,creat_time,update_time,deleted) value(?,?,?,?,?,?,?)";
            stockRecordDao.update(sql6, StockRecord.class,barCode,userId,purchaseCount,modify_type,new Date(),new Date(),0);
            //事务提交t
            conn.commit();
            flag=true;
        } catch (SQLException throwables) {
            try {
                conn.rollback();
                flag=false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
        return flag;
    }

    @Override
    public int insert(int productId, String purchaseDate, String proDate, String expDate, BigDecimal purchasePrice,
                      int purchaseCount, BigDecimal purchaseAmount) {
        String sql = "insert into biz_purchase(product_id,purchase_date,pro_date,exp_date,purchase_price,count,amount,creat_time,update_time,deleted) " +
                "value(?,?,?,?,?,?,?,?,?,?)";
        int count = 0;
        try {
            count = dao.update(sql, Purchase.class, productId, purchaseDate, proDate, expDate, purchasePrice, purchaseCount,
                    purchaseAmount, new Date(), new Date(), 0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }


    @Override
    public List<Product> show() {
        ProductDao productDao = new ProductDao(conn);
        List<Product> products = new ArrayList<>();
        String sql = "SELECT\n" +
                "\tpurchase.id,\n" +
                "\ts.supplier_name,\n" +
                "\tproduct.bar_code,\n" +
                "\tc.category_name,\n" +
                "\tproduct.product_name,\n" +
                "\tpurchase.purchase_price,\n" +
                "\tpurchase.count,\n" +
                "\tpurchase.amount,\n" +
                "\tpurchase.exp_date \n" +
                "FROM\n" +
                "\tbiz_product product,\n" +
                "\tbiz_supplier s,\n" +
                "\tbiz_purchase purchase,\n" +
                "\tbiz_category c \n" +
                "WHERE\n" +
                "\tproduct.deleted = 0 \n" +
                "\tAND s.deleted = 0 \n" +
                "\tAND purchase.deleted = 0 \n" +
                "\tAND c.deleted = 0 \n" +
                "\tAND product.category_id = c.id \n" +
                "\tAND product.supplier_id = s.id \n" +
                "\tAND product.id = purchase.product_id";
        try {
            products = productDao.listQuery(sql, Product.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> fuzzyQuery(String value) {
        ProductDao productDao = new ProductDao(conn);
        List<Product> products = new ArrayList<>();
        String sql = "SELECT\n" +
                "\tpurchase.id,\n" +
                "\ts.supplier_name,\n" +
                "\tproduct.bar_code,\n" +
                "\tc.category_name,\n" +
                "\tproduct.product_name,\n" +
                "\tpurchase.purchase_price,\n" +
                "\tpurchase.count,\n" +
                "\tpurchase.amount,\n" +
                "\tpurchase.exp_date \n" +
                "FROM\n" +
                "\tbiz_product product,\n" +
                "\tbiz_supplier s,\n" +
                "\tbiz_purchase purchase,\n" +
                "\tbiz_category c \n" +
                "WHERE\n" +
                "  product.product_name LIKE ?\n" +
                "\tAND product.deleted = 0 \n" +
                "\tAND s.deleted = 0 \n" +
                "\tAND purchase.deleted = 0 \n" +
                "\tAND c.deleted = 0 \n" +
                "\tAND product.category_id = c.id \n" +
                "\tAND product.supplier_id = s.id \n" +
                "\tAND product.id = purchase.product_id";
        try {
            products = productDao.listQuery(sql, Product.class, "%" + value + "%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }


    private Connection conn;
    private PurchaseDao dao;

    public PurchaseImpl() {
        conn = JDBCUtil.getInstance().getConnection();
        dao = new PurchaseDao(conn);
    }
}
