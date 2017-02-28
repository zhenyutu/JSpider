package cn.tzy.app.service;

import cn.tzy.app.dao.DatabaseConnection;
import cn.tzy.app.entity.Urls;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class ResultWrite {

    public static void saveResult(Map resultMap){
        Connection conn = DatabaseConnection.getInstance().getConnection();
        DatabaseService databaseService = DatabaseService.getInstance(conn);
        try {
            for(Object o : resultMap.entrySet()){
                Map.Entry obj = (Map.Entry)o;
                Urls urls = new Urls((String)obj.getKey(),(String)obj.getValue());
                databaseService.insert(conn,urls);
            }
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
