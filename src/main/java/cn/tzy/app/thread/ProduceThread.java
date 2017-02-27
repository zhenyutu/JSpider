package cn.tzy.app.thread;

import cn.tzy.app.service.ProduceService;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class ProduceThread extends Thread{
    private ProduceService produceService;
    public ProduceThread(ProduceService produceService){
        this.produceService = produceService;
    }

    @Override
    public void run() {

    }
}
