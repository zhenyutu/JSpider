package cn.tzy.app.baidubaike;

import cn.tzy.app.baidubaike.service.UrlManager;
import cn.tzy.app.baidubaike.thread.ConsumeThread;
import cn.tzy.app.baidubaike.thread.ProduceThread;

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

        /*********************** 生产者消费者模式  **********************/
        ProduceThread p1 = new ProduceThread(urlManager);
        p1.start();
        ProduceThread p2 = new ProduceThread(urlManager);
        p2.start();
        ProduceThread p3 = new ProduceThread(urlManager);
        p3.start();
        ProduceThread p4 = new ProduceThread(urlManager);
        p4.start();
        ConsumeThread c1 = new ConsumeThread(urlManager);
        c1.start();
        ConsumeThread c2 = new ConsumeThread(urlManager);
        c2.start();
        begin = System.currentTimeMillis();

        /*********************** 多条线程依次执行模式  **********************/
//        System.out.println("begin:"+begin);
//        Mythread t1 = new Mythread(urlManager);
//        Mythread t2 = new Mythread(urlManager);
//        Mythread t3 = new Mythread(urlManager);
//        Mythread t4 = new Mythread(urlManager);
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

        /*****************×××****** 普通爬虫  *************××××××*********/
//        urlManager.startCrawler();
    }
}
