package dao;

import model.Stock;

import java.sql.Connection;

public class StockDao extends BasicDao<Stock> {
    public StockDao(Connection conn) {
        super(conn);
    }
}
