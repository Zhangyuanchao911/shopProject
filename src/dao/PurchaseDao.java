package dao;

import model.Purchase;

import java.sql.Connection;

public class PurchaseDao extends BasicDao<Purchase>{
    public PurchaseDao(Connection conn) {
        super(conn);
    }
}
