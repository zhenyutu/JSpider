package cn.tzy.app.thread;

import cn.tzy.app.service.UrlManager;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class ConsumeThread extends Thread{
    private UrlManager urlManager;
    public ConsumeThread(UrlManager urlManager){
        this.urlManager = urlManager;
    }

    @Override
    public void run() {
        while (true){
            urlManager.consume();
        }

    }
}
