package cn.tzy.app;

import cn.tzy.app.service.UrlManager;
import cn.tzy.app.thread.Mythread;

import java.io.IOException;
/**
 * JSpider
 *@author tuzhenyu
 */
public class Main
{
    public static long begin;
    public static void main( String[] args ) throws IOException{
        UrlManager urlManager = new UrlManager();
        begin = System.currentTimeMillis();
        System.out.println("begin:"+begin);
        Mythread t1 = new Mythread(urlManager);
        Mythread t2 = new Mythread(urlManager);
        Mythread t3 = new Mythread(urlManager);
        Mythread t4 = new Mythread(urlManager);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
//        urlManager.startCrawler();
    }
}
