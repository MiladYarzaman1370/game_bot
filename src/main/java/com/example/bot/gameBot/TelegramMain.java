package com.example.bot.gameBot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramMain extends TelegramWebhookBot {
    private String botWebhookPath;
    private String botUserName;
    private String botToken;

    public TelegramMain(DefaultBotOptions options) {
        super(options);
    }

    public String getBotWebhookPath() {
        return botWebhookPath;
    }

    public void setBotWebhookPath(String botWebhookPath) {
        this.botWebhookPath = botWebhookPath;
    }

    public String getBotUserName() {
        return botUserName;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if(update.getMessage()!=null && update.getMessage().hasText()){

            long chatId=update.getMessage().getChatId();
            try {
                execute(new SendMessage(chatId,"Hi "+update.getMessage().getText()));
            }catch (TelegramApiException e){

            }
        }
        return null;
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }

    @Override
    public String getBotPath() {
        return null;
    }
}
