package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static JDBCUtil jdbcUtil;
    private Connection connection;
    private String driverClass;
    private String url;
    private String username;
    private String password;

    /**
     * 私有化构造器，用于单例模式
     */
    private JDBCUtil() {
    }

    /**
     * 获取jdbc实例对象
     *
     * @return jdbcUtil
     */
    public static JDBCUtil getInstance() {
        if (jdbcUtil == null) {
            synchronized (JDBCUtil.class) {
                if (jdbcUtil == null) {
                    jdbcUtil = new JDBCUtil();
                }
            }
        }
        return jdbcUtil;
    }

    /**
     * 获取数据库连接对象
     *
     * @return
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * 初始化数据库连接
     */
    private void initConnection() {
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过Properties对象从配置文件中获取连接属性
     *
     * @param pro
     */
    public void initFromProperties(Properties pro) {
        driverClass = pro.getProperty("driver-class");
        url = pro.getProperty("db-url");
        username = pro.getProperty("username");
        password = pro.getProperty("password");
        initConnection();
    }
}
