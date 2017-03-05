package cn.tzy.app.baidubaike.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tuzhenyu on 17-2-28.
 * @author tuzhenyu
 */
@Setter
@Getter
public class Urls {
    public Integer id;
    public String name;
    public String url;

    public Urls(String name,String url){
        this.name = name;
        this.url = url;
    }
}
