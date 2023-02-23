package com.ruoyi.chenckin.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.ruoyi.chenckin.common.RSSConfig;
import com.ruoyi.chenckin.util.telegram.TelegramConfig;
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


    /** 知乎专栏-每天六十秒 */
    public static String getZhiHuRss() throws DocumentException {
        String body = HttpUtil.createGet(RSSConfig.meiTianLiuShiMiao).execute().body();
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
        strJoiner.add(TelegramConfig.chatDailyNewsZH);
        // 在日期前增加#符号
        return strJoiner.toString().replace(newDayDate, "#" + newDayDate);
    }


    /**
     * rss订阅即刻一觉醒来圈子
     */
    public static String getJiKeRss() throws DocumentException {
        // String body = HttpUtil.createGet(RSSConfig.yiJiaoXingLai).execute().body();
        String body = HttpUtil.createGet("http://155.248.186.71:1200/jike/topic/text/553870e8e4b0cafb0a1bef68").execute().body();
        // 获取 <pubDate> 元素节点
        Document document = DocumentHelper.parseText(body);
        List<Element> item1 = document.getRootElement().element("channel").elements("item");
        Element item = item1.get(0);
        String pubDate = item.element("pubDate").getText();
        String description = item.element("description").getText().replace("<![CDATA[", "").replace(" ]]>", "");
        String[] split = description.split("<br>");
        // 获取 <pubDate> 元素节点的文本内容
        DateTime dateTime = DateUtil.parse(split[0]);
        // 判断是不是今天的新闻,最新的一条不是今天的新闻直接返回
        if (!DateUtil.isSameDay(dateTime, new Date())) {
            return null;
        }
        // 获取 <description> 元素节点的文本内容


        org.jsoup.nodes.Document jsoupDoc = Jsoup.parse(description);

        return null;

    }

    public static void main(String[] args) throws DocumentException {
        getJiKeRss();
    }


}
