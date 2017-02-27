package cn.tzy.app.service;

import java.util.*;

/**
 * Created by tuzhenyu on 17-2-27.
 * @author tuzhenyu
 */
public class UrlManager {
    public static LinkedList<String> newUrlQueue = new LinkedList<String>();
    public static Set<String> oldUrlQueue = new HashSet<String>();

    public static boolean addUrl(String url){
        if("".equals(url)){
            return false;
        }else if(newUrlQueue.contains(url)){
            return false;

        }else {
            newUrlQueue.add(url);
            return true;
        }
    }

    public static String outUrl(){
        String url = newUrlQueue.removeFirst();
        oldUrlQueue.add(url);
        return url;
    }

    public static boolean hasNewUrl(){
        return newUrlQueue.isEmpty();
    }


}
