package com.ruoyi.chenckin.util;

import com.ruoyi.chenckin.domain.TGMsgLog;
import com.ruoyi.chenckin.domain.TgNews;
import com.ruoyi.chenckin.service.ITGMsgLogService;
import com.ruoyi.chenckin.service.ITgNewsService;
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
    @Autowired
    private ITgNewsService tgNewsService;


    /**
     * 发送新闻
     */
    public void pushNews(List<TgNews> tgNewsList) {
        tgNewsList.forEach(tgNews -> {
            // 发送新闻,保存数据库记录
            Message sendMessageResult = TelegramUtils.sendMessage(TelegramConfig.chatDailyNewsZH, tgNews.getContent());
            TGMsgLog msgLog = new TGMsgLog();
            // 消息接收人
            msgLog.setChatId(TelegramConfig.chatDailyNewsZH);
            // 消息内容
            msgLog.setContent(tgNews.getContent());
            // 1成功,2失败
            msgLog.setStatu(sendMessageResult == null ? 2 : 1);
            // 1.每天60秒新闻
            msgLog.setTypes(1);
            // 结果内容
            msgLog.setResultContent(sendMessageResult == null ? "" : sendMessageResult.getText());
            if (sendMessageResult != null) {
                // 2.已经发送
                tgNews.setStatu(2);
            }
            tgMsgLogService.insertTGMsgLog(msgLog);
        });

        // 大于0,说明有新闻,更新新闻发送状态
        if (tgNewsList.size() > 0) {
            // 更新新闻状态
            tgNewsService.updateTgNewsList(tgNewsList);
        }

    }

}
