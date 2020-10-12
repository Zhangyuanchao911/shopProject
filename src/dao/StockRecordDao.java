package dao;

import model.StockRecord;

import java.sql.Connection;

public class StockRecordDao extends BasicDao<StockRecord>{

    public StockRecordDao(Connection conn) {
        super(conn);
    }
}
