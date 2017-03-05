package cn.tzy.app.lagou;

import cn.tzy.app.lagou.entity.JsonResult;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by tuzhenyu on 17-3-4.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        String result = null;
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.lagou.com/jobs/positionAjax.json?px=new");

        httpGet.setHeader("X-Requested-With", "XMLHttpRequest");
        httpGet.setHeader("Origin", "https://www.lagou.com");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Cookie", "user_trace_token=20170211115515-2db01e4efbb24178989f2b6139d3698e; LGUID=20170211115515-e593a6c4-f00d-11e6-8f71-5254005c3644; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; hasDeliver=0; index_location_city=%E5%85%A8%E5%9B%BD; login=false; unick=\"\"; _putrc=\"\"; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1486785316; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1486789519; _ga=GA1.2.1374329991.1486785316; LGRID=20170211130519-af0ec03c-f017-11e6-a32c-525400f775ce; TG-TRACK-CODE=search_code; JSESSIONID=A5AC6E7C54130E13C1519ABA7F70BC3C; SEARCH_ID=053c985ab53e463eb5f747658872ef29");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        try {

            HttpResponse response = httpclient.execute(httpGet);
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            Gson gson = new Gson();
            JsonResult jsonResult = gson.fromJson(result, JsonResult.class);
            System.out.println(jsonResult.getContent().getPositionResult().getResult());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            httpGet.releaseConnection();
        }

    }
}
