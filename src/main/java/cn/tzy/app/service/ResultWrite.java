package cn.tzy.app.service;

import java.util.Map;

/**
 * Created by tuzhenyu on 17-2-27.
 */
public class ResultWrite {

    public static void printResult(Map resultMap){
        for(Object o : resultMap.entrySet()){
            Map.Entry obj = (Map.Entry)o;
            System.out.println("key:"+obj.getKey()+" value:"+obj.getValue());
        }
    }

}
