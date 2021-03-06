package cn.tzy.app.baidubaike.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class HtmlParse {

    public static Map parseHtml(String htmlContent){
        Map<String,String> resultMap = new HashMap<String,String>();
        Document doc = Jsoup.parse(htmlContent);
        Elements links = doc.select("a[href*=/view]");
        for (Element link : links) {
            resultMap.put(link.text(),"http://baike.baidu.com"+link.attr("href"));
        }
        return resultMap;
    }

}
