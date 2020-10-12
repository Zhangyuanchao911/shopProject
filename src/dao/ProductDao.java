package dao;

import model.Product;

import java.sql.Connection;
import java.util.List;

public class ProductDao extends BasicDao<Product>{


    public ProductDao(Connection conn) {
        super(conn);
    }
//    Dao dao = new Dao();
//
//    public boolean add(Product product) {
//        String sql = "insert into biz_product(bar_code,supplier_id,category_id,product_name,product_price,creat_time,update_time,deleted) " +
//                "value(?,?,?,?,?,?,?,?)";
//        return dao.update(sql, product.getBar_code(), product.getSupplier_id(), product.getCategory_id(), product.getProduct_name(), product.getProduct_price()
//                , product.getCreat_time(), product.getUpdate_time(), product.getDeleted());
//
//    }
//    public List<Product> select(){
//        String sql="select * from biz_product";
//        return dao.select(sql,Product.class);
//    }
//    public Product selectFuzzy(String value){
//        String sql="select * from biz_product where product_name like ?";
//        Product p = null;
//        List<Product> list= dao.selectByValue(sql,Product.class,"%"+value+"%");
//        if (list!=null){
//            p=list.get(0);
//        }
//        return p;
//    }
//    public boolean update(Product product){
//        String sql="update biz_product set bar_code=?,supplier_id=?" +
//                ",category_id=?,product_name=?,product_price=?,update_time=? where id=?" ;
//       return dao.update(sql,product.getBar_code(),product.getSupplier_id(),product.getCategory_id(),product.getProduct_name(),
//                product.getProduct_price(),product.getUpdate_time(),product.getId());
//    }
//    public boolean deleted(int id){
//          String sql="update biz_product set deleted=1 where id=?";
//         return dao.update(sql,id);
//    }
//
//    public static void main(String[] args) {
//       ProductDao dao=new ProductDao();
//       Product product=dao.selectFuzzy("源");
//        System.out.println(product.toString());
//    }
}
