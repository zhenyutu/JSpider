package cn.tzy.app.service;

import java.util.*;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class UrlManager {
    public LinkedList<String> urlQueue = new LinkedList<String>();

    public boolean addUrl(String url){
        if("".equals(url)){
            return false;
        }else if(urlQueue.contains(url)){
            return false;

        }else {
            urlQueue.add(url);
            return true;
        }
    }

    public String outUrl(){
        String url = urlQueue.removeFirst();
        return url;
    }

    public void updateUrlQueue(Map resultMap){
        for(Object o : resultMap.entrySet()){
            Map.Entry obj = (Map.Entry)o;
            addUrl((String)(obj.getValue()));
        }
    }

    public void startCrawler(String url){
        addUrl(url);
        while (urlQueue.size()>0){
            String newUrl = outUrl();
            String page = HtmlDownloads.getPageContent(newUrl);
            Map resultMap = HtmlParse.parseHtml(page);
            updateUrlQueue(resultMap);
            ResultWrite.printResult(resultMap);
        }

    }


}
