package cn.tzy.app.dao;

import cn.tzy.app.entity.Config;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

/**
 * Created by tuzhenyu on 17-2-28.
 * @author tuzhenyu
 */
public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private static ComboPooledDataSource dataSource = null;

    private DatabaseConnection() throws PropertyVetoException {
        dataSource = new ComboPooledDataSource();

        dataSource.setUser(Config.username);
        dataSource.setPassword(Config.password);
        dataSource.setJdbcUrl(Config.url);
        dataSource.setDriverClass(Config.driver);

        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(1);
        dataSource.setMaxPoolSize(10);
        dataSource.setMaxStatements(50);
        dataSource.setMaxIdleTime(60);
    }

    public static DatabaseConnection getInstance(){
        try {
            if (instance == null){
                instance = new DatabaseConnection();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }

    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
