package cn.tzy.app;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException{
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://www.baidu.com");
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();

        if (entity != null)
        {
            String content = EntityUtils.toString(entity);
            System.out.println(content);

        }

    }
}
