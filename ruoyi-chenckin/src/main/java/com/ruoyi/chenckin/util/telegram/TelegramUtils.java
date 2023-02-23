package com.ruoyi.chenckin.util.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

/**
 * @author: [圖神] 'wobushitushen@gmail.com'
 * @Date: 2022-02-25 17:16
 * @Description: < 描述 >
 */
public class TelegramUtils {

    private static TelegramBotInit telegramBot = TelegramBotInit.getBot();

    /**
     * 描述: 发送单个图片和消息
     *
     * @param file 图片文件
     * @return
     * @author 圖神
     * @since 2022/3/1
     */
    public static void postImgOne(File file, String caption) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId("");
        sendPhoto.setPhoto(new InputFile(file));
        sendPhoto.setDisableNotification(true);
        sendPhoto.setCaption(caption);
        try {
            telegramBot.execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息
     *
     * @param chatId  聊天id
     * @param caption 消息内容
     * @return
     */
    public static Message sendMessage(String chatId, String caption) {
        SendMessage sendMessage = new SendMessage(chatId, caption);
        sendMessage.setDisableNotification(true);
        try {
            return telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}

