package cn.tzy.app.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class Config {
    public static String rootUrl;   //初始URL

    static{
        Properties config = new Properties();

        try{
            FileInputStream in = new FileInputStream("src/main/resource/config.properties");
            config.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        rootUrl = config.getProperty("rootUrl");
    }
}
