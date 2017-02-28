package cn.tzy.app.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class HtmlDownloads {

    public static String getPageContent(String url){
        String page = null;
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            page = EntityUtils.toString(response.getEntity(),"utf-8");
            httpget.releaseConnection();
        }catch (Exception e){
            e.printStackTrace();
        }

        return page;
    }
}
