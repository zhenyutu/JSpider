package cn.tzy.app.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class HtmlDownloads {

    private String getPageContent(){

        String page = null;
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet("http://baike.baidu.com/item/Python");
            HttpResponse response = httpclient.execute(httpget);
            page = EntityUtils.toString(response.getEntity(),"utf-8");
            httpget.releaseConnection();
        }catch (IOException e){
            e.printStackTrace();
        }

        return page;
    }
    public void startCrawler(){
        HtmlParse htmlParse = new HtmlParse();
        String page = getPageContent();
        htmlParse.parseHtml(page);
    }
}
