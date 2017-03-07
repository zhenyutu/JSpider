package cn.tzy.app.lagou;

import cn.tzy.app.lagou.entity.JsonResult;
import cn.tzy.app.lagou.util.HttpUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-3-4.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        String url = "http://www.lagou.com/jobs/positionAjax.json?px=new";

//        Map<String,String> params = new HashMap<>();
//        params.put("first","true");
//        params.put("kd","java");
//        params.put("pn","333");
//        String result = HttpUtil.post(url,params);

        String result = HttpUtil.get(url);

        System.out.println(result);
//        Gson gson = new Gson();
//        JsonResult jsonResult = gson.fromJson(result, JsonResult.class);
//        System.out.println(jsonResult.getContent().getPositionResult().getResult());
    }
}
