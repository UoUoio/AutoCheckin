package com.ruoyi.chenckin.util.telegram;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramBotInit extends TelegramLongPollingBot implements TelegramConfig{



    public static TelegramBotInit getBot() {
        return BotInit.BOT.telegramBot;
    }

    private TelegramBotInit(DefaultBotOptions botOptions) {
        super(botOptions);
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Create a SendMessage object with mandatory fields
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());

            try {
                // Call method to send the message
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String getBotUsername() {
        return UserName;
    }

    @Override
    public String getBotToken() {
        return Token;
    }

    /**
     * 描述:单例初始化Bot
     *
     * @author 圖神 [wobushitushen@gmail.com]
     */
    public enum BotInit {
        BOT;
        private TelegramBotInit telegramBot;

        private BotInit() {
            DefaultBotOptions botOptions = new DefaultBotOptions();
            telegramBot = new TelegramBotInit(botOptions);
            try {
                TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
                // 代理信息设置进去
                botsApi.registerBot(telegramBot);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}

