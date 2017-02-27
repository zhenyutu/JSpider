package cn.tzy.app.service;

import cn.tzy.app.Main;

import java.util.*;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class UrlManager {
    private LinkedList<String> urlQueue = new LinkedList<String>();
    private List<String> allUrl = new ArrayList<String>();

    public UrlManager(){
        String rootUrl = "http://baike.baidu.com/item/Python";
        urlQueue.add(rootUrl);

    }

    synchronized private boolean addUrl(String url){
        if("".equals(url)){
            return false;
        }else if(urlQueue.contains(url)){
            return false;

        }else {
            urlQueue.add(url);
            return true;
        }
    }

    synchronized private String outUrl(){
        String url = urlQueue.removeFirst();
        return url;
    }

    synchronized private void updateUrlQueue(Map resultMap){
        for(Object o : resultMap.entrySet()){
            Map.Entry obj = (Map.Entry)o;
            addUrl((String)(obj.getValue()));
            allUrl.add((String)(obj.getValue()));
        }
    }

    public void startCrawler(){
        while (urlQueue.size()>0){
            String newUrl = outUrl();
            String page = HtmlDownloads.getPageContent(newUrl);
            Map resultMap = HtmlParse.parseHtml(page);
            updateUrlQueue(resultMap);
            try {
                if (allUrl.size()>1000){
                    System.out.println("end:"+(System.currentTimeMillis()- Main.begin));
                    throw new InterruptedException();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
//            ResultWrite.printResult(resultMap);
        }

    }

    public void crawler(){
        if (urlQueue.size()>0){
            String newUrl = outUrl();
            String page = HtmlDownloads.getPageContent(newUrl);
            Map resultMap = HtmlParse.parseHtml(page);
            updateUrlQueue(resultMap);
            try {
                if (allUrl.size()>1000){
                    System.out.println("end:"+(System.currentTimeMillis()- Main.begin));
                    throw new InterruptedException();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

//            ResultWrite.printResult(resultMap);
        }

    }

}
