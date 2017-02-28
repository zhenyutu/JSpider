package cn.tzy.app.entity;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class Config {

    public static String rootUrl;   //初始URL

    public static String url;   //初始URL
    public static String username;   //初始URL
    public static String password;   //初始URL
    public static String driver;   //初始URL

    static{
        Properties config = new Properties();

        try{
            FileInputStream in = new FileInputStream("src/main/resources/config.properties");
            config.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        rootUrl = config.getProperty("rootUrl");

        url = config.getProperty("jdbc.url");
        username = config.getProperty("jdbc.username");
        password = config.getProperty("jdbc.password");
        driver = config.getProperty("jdbc.driver");
    }
}
