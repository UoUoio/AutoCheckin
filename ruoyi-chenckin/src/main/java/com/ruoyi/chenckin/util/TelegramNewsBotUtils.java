package com.ruoyi.chenckin.util;

import com.ruoyi.chenckin.domain.TGMsgLog;
import com.ruoyi.chenckin.domain.TgNews;
import com.ruoyi.chenckin.service.ITGMsgLogService;
import com.ruoyi.chenckin.util.telegram.TelegramConfig;
import com.ruoyi.chenckin.util.telegram.TelegramUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

/**
 * @author:
 * @Date: 2023-02-18 15:19
 * @Description: < 描述 >
 */
@Component
public class TelegramNewsBotUtils {

    @Autowired
    private ITGMsgLogService tgMsgLogService;


    /**
     * 发送新闻
     */
    public void pushNews(List<TgNews> tgNewsList) {

        tgNewsList.forEach(tgNews -> {
            // 发送新闻,保存数据库记录
            Message sendMessageResult = TelegramUtils.sendMessage(TelegramConfig.Chat_DailyNewsZH, tgNews.getContent());
            TGMsgLog msgLog = new TGMsgLog();
        });


    }
}
