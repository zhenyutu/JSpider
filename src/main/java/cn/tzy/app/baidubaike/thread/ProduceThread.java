package cn.tzy.app.baidubaike.thread;

import cn.tzy.app.baidubaike.service.UrlManager;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class ProduceThread extends Thread{
    private UrlManager urlManager;
    public ProduceThread(UrlManager urlManager){
        this.urlManager = urlManager;
    }

    @Override
    public void run() {
        while (true){
            urlManager.produce();
        }
    }
}
