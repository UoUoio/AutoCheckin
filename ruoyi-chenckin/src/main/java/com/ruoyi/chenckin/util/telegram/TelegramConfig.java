package com.ruoyi.chenckin.util.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Date: 2022-03-01 14:45
 * @Description: < 一些常量 >
 */
@Component
@ConfigurationProperties(prefix = "telegram")
public class TelegramConfig {
    /**
     * 每日新闻频道
     */

    public static String chatDailyNewsZH;
    /**
     * 测试消息频道
     */
    public static String botsMsg;
    /**
     * Bot名称
     */
    public static String botUserName;
    /**
     * Bot Token
     */
    public static String botToken;

    @Value("${chatDailyNewsZH}")
    public static void setChatDailyNewsZH(String chatDailyNewsZH) {
        TelegramConfig.chatDailyNewsZH = chatDailyNewsZH;
    }

    @Value("${botsMsg}")
    public static void setBotsMsg(String botsMsg) {
        TelegramConfig.botsMsg = botsMsg;
    }

    @Value("${botUserName}")
    public static void setBotUserName(String botUserName) {
        TelegramConfig.botUserName = botUserName;
    }

    @Value("${botToken}")
    public static void setBotToken(String botToken) {
        TelegramConfig.botToken = botToken;
    }
}