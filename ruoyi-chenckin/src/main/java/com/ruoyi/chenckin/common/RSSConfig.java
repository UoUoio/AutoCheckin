package com.ruoyi.chenckin.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:
 * @Date: 2023-02-21 17:23
 * @Description: < 描述 >
 */
@Component
@ConfigurationProperties(prefix = "rss")
public class RSSConfig {


    /**
     * 每天六十秒读懂世界
     */
    public static String meiTianLiuShiMiao;
    /**
     * 一觉醒来发生了什么
     */
    public static String yiJiaoXingLai;


    @Value("${meiTianLiuShiMiao}")
    public static void setMeiTianLiuShiMiao(String meiTianLiuShiMiao) {
        RSSConfig.meiTianLiuShiMiao = meiTianLiuShiMiao;
    }

    @Value("${yiJiaoXingLai}")
    public static void setYiJiaoXingLai(String yiJiaoXingLai) {
        RSSConfig.yiJiaoXingLai = yiJiaoXingLai;
    }
}
