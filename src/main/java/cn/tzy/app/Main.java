package cn.tzy.app;


import cn.tzy.app.entity.Config;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ){

        System.out.println(Config.rootUrl);
//        HttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpget = new HttpGet("http://www.baidu.com");
//        HttpResponse response = httpclient.execute(httpget);
//        HttpEntity entity = response.getEntity();
//
//        if (entity != null)
//        {
//            String content = EntityUtils.toString(entity);
//            System.out.println(content);
//
//        }

    }
}
