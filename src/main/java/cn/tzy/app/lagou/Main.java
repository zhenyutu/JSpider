package cn.tzy.app.lagou;

import cn.tzy.app.lagou.util.HttpUtil;

/**
 * Created by tuzhenyu on 17-3-4.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
//        String url = "http://www.lagou.com/jobs/positionAjax.json?px=new";
        String url = "https://www.lagou.com/jobs/2552408.html";

        String result = HttpUtil.get(url);
        System.out.println(result);
    }
}
