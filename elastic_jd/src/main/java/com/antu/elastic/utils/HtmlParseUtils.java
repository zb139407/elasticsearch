package com.antu.elastic.utils;

import com.antu.elastic.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class HtmlParseUtils {
//    public static void main(String[] args) throws Exception {
//        new HtmlParseUtils().parseJD("java").forEach(System.out::println);
//    }

    public List<Content> parseJD(String keywords) throws Exception {
        // 获取请求 https://search.jd.com/Search?keyword=java
        // 需要联网，不能获取ajax数据
        String url = "https://search.jd.com/Search?keyword=" + keywords;
        // 解析网页(Jsoup返回Document就是浏览器Document页面对象)
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
//        System.out.println(element.html());
        // 获取所有的li元素
        Elements elements = element.getElementsByTag("li");
        List<Content> goodsList = new ArrayList<>();
        // 获取元素内容，这里的el就是每一个li标签
        for (Element el : elements) {
            // 图片特别多的网站，所有的图片都是延迟加载的
            // source-data-lazy-img
            String img = el.getElementsByTag("img").eq(0).attr("src");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();

            Content content = new Content();
            content.setTitle(title);
            content.setPrice(price);
            content.setImg(img);
            goodsList.add(content);
        }
        return goodsList;
    }
}
