package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

public class BasicDao<T>{
    private Connection conn;
    private QueryRunner queryRunner=new QueryRunner();
    public BasicDao(Connection conn){
        this.conn=conn;
    }

    /**
     * 查询单条数据
     * @param sql
     * @param clazz
     * @param params
     * @return
     * @throws SQLException
     */
    public T queryOne(String sql, Class<T> clazz, Object... params) throws SQLException {
        T t=queryRunner.query(conn,sql, new BeanHandler<>(clazz),params);
        return t;
    }

    /**
     *  查询所有数据
     * @param sql
     * @param clazz
     * @param params
     * @return
     * @throws SQLException
     */
    public List<T> listQuery(String sql,Class<T> clazz,Object ...params) throws SQLException {
        List<T> list =queryRunner.query(conn,sql,new BeanListHandler<>(clazz),params);
        return list;
    }
    public int update(String sql,Class<T> clazz,Object ...params) throws SQLException {
        int count=queryRunner.update(conn,sql,params);
        return count;
    }
    /**
     * 添加数据，返回主键
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
    public int addWithBackPK(String sql, Object[] params) throws Exception {
        PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        int i = 1;
        for (Object obj : params) {
            preparedStatement.setObject(i, obj);
            i++;
        }
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        long generateKey = 0;
        while (generatedKeys.next()) {
            generateKey = generatedKeys.getLong(1);
        }
        return (int)generateKey;
    }

    /**
     * 批量更新，批量对数据库写操作
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
    public int updateBatch(String sql, Object[][] params) throws Exception {
        QueryRunner runner = new QueryRunner();
        int cou = runner.batch(conn, sql, params).length;
        return cou;
    }

}
