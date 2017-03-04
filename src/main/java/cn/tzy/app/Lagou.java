package cn.tzy.app;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by tuzhenyu on 17-3-4.
 * @author tuzhenyu
 */
public class Lagou {
    public static void main(String[] args) {
        String page = null;
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet("http://www.lagou.com/jobs/positionAjax.json?px=new");
            HttpResponse response = httpclient.execute(httpget);
            page = EntityUtils.toString(response.getEntity(),"utf-8");
            httpget.releaseConnection();
            System.out.println(page);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
