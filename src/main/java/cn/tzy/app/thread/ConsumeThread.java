package cn.tzy.app.thread;

import cn.tzy.app.service.ConsumeService;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class ConsumeThread extends Thread{
    private ConsumeService consumeService;
    public ConsumeThread(ConsumeService consumeService){
        this.consumeService = consumeService;
    }

    @Override
    public void run() {

    }
}
