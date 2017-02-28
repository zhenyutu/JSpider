package cn.tzy.app.service;

import cn.tzy.app.Main;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class UrlManager {
    private LinkedList<String> pageQueue = new LinkedList<String>();
    private LinkedList<String> urlQueue = new LinkedList<String>();
    private List<String> allUrl = new ArrayList<String>();

    Logger logger = Logger.getLogger ( DatabaseService.class.getName());

    public UrlManager(){
        String rootUrl = "http://baike.baidu.com/item/Python";
        urlQueue.add(rootUrl);
    }

    private String outUrl(){
        String url = urlQueue.removeFirst();
        return url;
    }

    private String outPage(){
        String page = pageQueue.removeFirst();
        return page;
    }

    private void updateUrlQueue(Map resultMap){
        for(Object o : resultMap.entrySet()){
            Map.Entry obj = (Map.Entry)o;
            urlQueue.offer((String)(obj.getValue()));
            allUrl.add((String)(obj.getValue()));
        }
    }

    private void testTime(){
        try {
            if (allUrl.size()>1000){
                System.out.println("end:"+(System.currentTimeMillis()- Main.begin));
                throw new InterruptedException();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



    /*********************** 生产者消费者模式模式  **********************/
    public void produce(){
        String newUrl;
        try{
            synchronized (this){
                while (urlQueue.size() == 0 || pageQueue.size() > 10){
                    logger.warn("urlQueue.size():"+urlQueue.size()+" pageQueue.size():"+pageQueue.size());
                    logger.warn("urlList:"+urlQueue.size());
                    logger.warn("下载线程"+Thread.currentThread().getName()+"is waiting");
                    this.wait();
                }
                newUrl = outUrl();
            }
            logger.warn("urlList:"+urlQueue.size());
            System.out.println("线程"+Thread.currentThread().getName()+"is fetching "+ newUrl);
            String page = HtmlDownloads.getPageContent(newUrl);
            synchronized (this){
                pageQueue.offer(page);
                this.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        testTime();

    }

    public void consume(){
        String page;
        try{
            synchronized (this){
                while (pageQueue.size() == 0){
                    logger.warn("pageList:"+pageQueue.size());
                    logger.warn("解析线程"+Thread.currentThread().getName()+"is waiting");
                    this.wait();
                }
                page = outPage();
            }
            logger.warn("pageList:"+pageQueue.size());
            System.out.println("线程"+Thread.currentThread().getName()+"is parsing ");
            Map resultMap = HtmlParse.parseHtml(page);
            synchronized (this){
                updateUrlQueue(resultMap);
                System.out.println("updateUrlQueue:"+urlQueue.size());
                notifyAll();
            }
            ResultWrite.saveResult(resultMap);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        testTime();

    }

    /*********************** 多条线程依次执行模式  **********************/
    public void startCrawler(){
        while (urlQueue.size()>0){
            String newUrl = outUrl();
            String page = HtmlDownloads.getPageContent(newUrl);
            Map resultMap = HtmlParse.parseHtml(page);
            ResultWrite.saveResult(resultMap);
            updateUrlQueue(resultMap);
            testTime();
        }

    }

    /*********************** 普通模式爬虫函数  **********************/
    public void crawler(){
        if (urlQueue.size()>0){
            String newUrl = outUrl();
            String page = HtmlDownloads.getPageContent(newUrl);
            Map resultMap = HtmlParse.parseHtml(page);
            ResultWrite.saveResult(resultMap);
            updateUrlQueue(resultMap);

            testTime();
        }

    }

}
