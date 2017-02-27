package cn.tzy.app;

import cn.tzy.app.service.HtmlDownloads;
import cn.tzy.app.service.UrlManager;

import java.io.IOException;
/**
 * JSpider
 *@author tuzhenyu
 */
public class Main
{
    public static void main( String[] args ) throws IOException{
        String rootUrl = "http://baike.baidu.com/item/Python";
        UrlManager urlManager = new UrlManager();
        urlManager.startCrawler(rootUrl);
    }
}
