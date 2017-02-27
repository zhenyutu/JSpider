package cn.tzy.app;

import cn.tzy.app.service.HtmlDownloads;
import java.io.IOException;
/**
 * JSpider
 *@author tuzhenyu
 */
public class Main
{
    public static void main( String[] args ) throws IOException{
        HtmlDownloads htmlDownloads = new HtmlDownloads();
        htmlDownloads.startCrawler();
    }
}
