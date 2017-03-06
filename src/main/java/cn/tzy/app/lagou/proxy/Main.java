package cn.tzy.app.lagou.proxy;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by tuzhenyu on 17-3-6.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("58.22.61.211",3128));

        HttpURLConnection connection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection(proxy);
        connection.setConnectTimeout(6000); // 6s
        connection.setReadTimeout(6000);
        connection.setUseCaches(false);

        if(connection.getResponseCode() == 200){
            System.out.println("使用代理IP连接网络成功");
        }
    }
}
