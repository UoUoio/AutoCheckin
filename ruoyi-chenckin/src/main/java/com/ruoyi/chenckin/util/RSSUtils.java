package com.ruoyi.chenckin.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author: rss新闻订阅
 * @Date: 2022-08-24 20:46
 * @Description: < 描述 >
 */
public class RSSUtils {


    /** 知乎专栏 */
    public static String getZhiHuRss() throws DocumentException {
        System.err.println(":执行了rss");

        HttpRequest request = HttpUtil.createGet("http://155.248.186.71:1200/zhihu/zhuanlan/c_1261258401923026944");

        String body = request.execute().body();
        // 获取并解析Rss中的内容
        Document document = DocumentHelper.parseText(body);
        List<Element> elements = document.getRootElement().element("channel").elements("item");

        String text = elements.get(0).elementText("description");
        // 使用爬虫框架获取数据
        org.jsoup.nodes.Document jsoupDoc = Jsoup.parse(text);
        Elements htmlEle = jsoupDoc.select("p[data-pid]");
        // 第二个为时间,判断是不是今天的新闻
        String htmlDateStr = htmlEle.get(1).text();
        String newDayDate = DateUtil.format(new Date(), "M月d日");
        // 不包含,说明不是今天的新闻 不更新
        if (!htmlDateStr.contains(newDayDate)) {
            return null;
        }
        StringJoiner strJoiner = new StringJoiner("\n\n");

        // ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓是今天的新闻↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        for (org.jsoup.nodes.Element element : htmlEle) {
            strJoiner.add(element.text());
        }
        strJoiner.add("@DailyNewsZH");
        // 在日期前增加#符号
        return strJoiner.toString().replace(newDayDate, "#" + newDayDate);
    }


}
