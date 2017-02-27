package cn.tzy.app.service;

import java.util.*;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class UrlManager {
    public static LinkedList<String> urlQueue = new LinkedList<String>();

    public static boolean addUrl(String url){
        if("".equals(url)){
            return false;
        }else if(urlQueue.contains(url)){
            return false;

        }else {
            urlQueue.add(url);
            return true;
        }
    }

    public static String outUrl(){
        String url = urlQueue.removeFirst();
        return url;
    }

    public static boolean hasNewUrl(){
        return urlQueue.isEmpty();
    }


}
