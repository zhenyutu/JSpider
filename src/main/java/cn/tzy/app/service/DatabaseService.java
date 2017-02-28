package cn.tzy.app.service;

import cn.tzy.app.entity.Config;
import cn.tzy.app.entity.Urls;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by tuzhenyu on 17-2-28.
 * @author tuzhenyu
 */
public class DatabaseService {
    private static DatabaseService instance = null;
    Logger logger = Logger.getLogger ( DatabaseService.class.getName());

    public DatabaseService(Connection conn){
        ResultSet rs = null;
        try {
            rs = conn.getMetaData().getTables(null, null, "urls", null);
            Statement st = conn.createStatement();
            //不存在url表
            if(!rs.next()){
                //创建url表
                st.execute(Config.createUrlTable);
                logger.info("url表创建成功");
            }
            else{
                logger.info("url表已存在");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseService getInstance(Connection conn){
        try {
            if (instance == null){
                instance = new DatabaseService(conn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }

    public void insert(Connection conn,Urls urls){
        String sql = "insert into urls(name,url) value('"+urls.getName()+"','"+urls.getUrl()+"')";
        System.out.println(sql);

        try{
            PreparedStatement pstmt;
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
