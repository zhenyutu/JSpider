package cn.tzy.app.baidubaike.thread;

import cn.tzy.app.baidubaike.service.UrlManager;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class Mythread extends Thread{
    private UrlManager urlManager;

    public Mythread(UrlManager urlManager){
        this.urlManager = urlManager;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+"is fetching");
            urlManager.crawler();
        }
    }
}
