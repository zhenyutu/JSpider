package cn.tzy.app.lagou.proxy;

import cn.tzy.app.lagou.entity.MyProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tuzhenyu on 17-3-8.
 * @author tuzhenyu
 */
public class ProxyPool {
    private List<MyProxy> proxyPool = new ArrayList<>();
    Random random = new Random();

    public void ProxyPoolInit(){

    }

    synchronized public MyProxy getProxy(){
        return proxyPool.get(random.nextInt(proxyPool.size()-1));
    }

    public void releaseProxy(MyProxy myProxy){
        proxyPool.add(myProxy);
    }

    public void removeProxy(MyProxy myProxy){
        proxyPool.remove(myProxy);
    }
}
