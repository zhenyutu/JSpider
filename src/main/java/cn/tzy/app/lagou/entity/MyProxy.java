package cn.tzy.app.lagou.entity;

import com.sun.javafx.binding.StringFormatter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by tuzhenyu on 17-3-8.
 * @author tuzhenyu
 */
public class MyProxy {

    /** 代理ip */
    private String ip;

    /** 代理端口 */
    private Integer port;

    /**
     * 检查代理是否存活
     * @return  存活与否
     */
    private boolean isAlive(){

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.ip, this.port));

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection(proxy);
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);
            connection.setUseCaches(false);

            if(connection.getResponseCode() == 200){
                return true;
            }

        }catch (IOException e){
            return false;
        }

        return true;
    }

}
