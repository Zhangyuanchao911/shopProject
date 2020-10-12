package dao;

import model.Supplier;

import java.sql.Connection;
import java.util.List;

public class SupplierDao extends BasicDao<Supplier>{
    public SupplierDao(Connection conn) {
        super(conn);
    }

//    Dao dao =new Dao();
//    public boolean add(Supplier supplier){
//        String sql="insert into biz_supplier (supplier_name,contacts_name,address,tel,creat_time,update_time,deleted) value(?,?,?,?,?,?,?)";
//        boolean flag= dao.update(sql,supplier.getSupplier_name(),supplier.getContacts_name(),supplier.getAddress(),supplier.getTel(),supplier.getCreat_time(),
//                supplier.getUpdate_time(),supplier.getDeleted() );
//        return flag;
//    }
//    public boolean delete(int id){
//        String sql="update biz_supplier set deleted=1 where id=?";
//        boolean flag= dao.update(sql,id);
//        return flag;
//    }
//    public boolean update(Supplier s){
//        String sql="update biz_supplier set supplier_name=?,contacts_name=?,address=?,tel=?,update_time=?";
//        return dao.update(sql,s.getSupplier_name(),s.getContacts_name(),s.getAddress(),s.getTel(),s.getUpdate_time());
//    }
//    public List<Supplier> select(){
//        String sql="select * from biz_supplier";
//        return dao.select(sql,Supplier.class);
//    }
}
