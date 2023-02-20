package com.ruoyi.quartz.task;

import com.ruoyi.chenckin.domain.TgNews;
import com.ruoyi.chenckin.service.ITgNewsService;
import com.ruoyi.chenckin.util.TelegramNewsBotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:
 * @Date: 2023-02-18 16:10
 * @Description: < 描述 >
 */
@Component("telegramMSG")
public class TelegramMSG {

    @Autowired
    private TelegramNewsBotUtils telegramNewsBotUtils;
    @Autowired
    private ITgNewsService tgNewsService;

    /**
     * 发送Tg消息
     */
    public void pushMsg() {
        // 获取所有没发送的新闻 1.没发送
        List<TgNews> tgNewsList = tgNewsService.selectTgNewsByStatu(1);

        // 发送新闻
        telegramNewsBotUtils.pushNews(tgNewsList);

    }


}
