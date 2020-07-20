package com.example.bot.gameBot.services;

import com.example.bot.gameBot.TelegramMain;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ManageNewMessage {

    private final TelegramMain telegramMain;
    public ManageNewMessage(TelegramMain telegramMain){
        this.telegramMain=telegramMain;
    }
    public BotApiMethod<?> manageUpdate(Update update)
    {

        return telegramMain.onWebhookUpdateReceived(update);
    }

}
