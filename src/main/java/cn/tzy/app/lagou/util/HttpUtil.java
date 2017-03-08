package cn.tzy.app.lagou.util;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-3-5.
 * @author tuzhenyu
 */
public class HttpUtil {

    private static  HttpClient httpclient;

    static {
        httpclient = HttpClients.createDefault();
    }

    /**
     * 模拟浏览器get请求
     * @param url　请求地址
     * @return 响应内容
     */
    public static String get(String url){
        String result = null;
        HttpGet httpGet = new HttpGet(url);

        HttpHost proxy = new HttpHost("119.29.126.115", 80);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(config);

        httpGet.setHeader("X-Requested-With", "XMLHttpRequest");
        httpGet.setHeader("Origin", "https://www.lagou.com");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        httpGet.setHeader("Cookie", "user_trace_token=20170211115515-2db01e4efbb24178989f2b6139d3698e; LGUID=20170211115515-e593a6c4-f00d-11e6-8f71-5254005c3644; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; hasDeliver=0; index_location_city=%E5%85%A8%E5%9B%BD; login=false; unick=\"\"; _putrc=\"\"; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1486785316; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1486789519; _ga=GA1.2.1374329991.1486785316; LGRID=20170211130519-af0ec03c-f017-11e6-a32c-525400f775ce; TG-TRACK-CODE=search_code; JSESSIONID=A5AC6E7C54130E13C1519ABA7F70BC3C; SEARCH_ID=053c985ab53e463eb5f747658872ef29");

        try {
            HttpResponse response = httpclient.execute(httpGet);
            result = EntityUtils.toString(response.getEntity(),"utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            httpGet.releaseConnection();
        }

        return result;
    }

    /**
     * 模拟浏览器post请求
     * @param url 发送地址url
     * @param paramsMap 表单参数
     * @return  返回请求结果
     */

    public static String post(String url, Map<String,String> paramsMap){
        String result = null;
        HttpPost httpPost = new HttpPost(url);

        HttpHost proxy = new HttpHost("113.200.29.10", 9999);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setProxy(proxy);
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        List<NameValuePair> params = new ArrayList<>();
        httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
        httpPost.setHeader("Origin", "https://www.lagou.com");
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        httpPost.setHeader("Cookie", "user_trace_token=20170211115515-2db01e4efbb24178989f2b6139d3698e; LGUID=20170211115515-e593a6c4-f00d-11e6-8f71-5254005c3644; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; hasDeliver=0; index_location_city=%E5%85%A8%E5%9B%BD; login=false; unick=\"\"; _putrc=\"\"; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1486785316; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1486789519; _ga=GA1.2.1374329991.1486785316; LGRID=20170211130519-af0ec03c-f017-11e6-a32c-525400f775ce; TG-TRACK-CODE=search_code; JSESSIONID=A5AC6E7C54130E13C1519ABA7F70BC3C; SEARCH_ID=053c985ab53e463eb5f747658872ef29");

        for (Map.Entry<String,String> entry : paramsMap.entrySet()){
            params.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = closeableHttpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(),"utf-8");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            httpPost.releaseConnection();
        }

        return result;
    }
}
