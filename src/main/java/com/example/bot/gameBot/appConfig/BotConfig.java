package com.example.bot.gameBot.appConfig;

import com.example.bot.gameBot.TelegramMain;
import com.example.bot.gameBot.services.ManageNewMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String botWebhookPath;
    private String botUserName;
    private String botToken;
    private DefaultBotOptions.ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;
    @Bean
    public TelegramMain MySuperTelegramBot(){
        DefaultBotOptions defaultBotOptions= ApiContext.getInstance(DefaultBotOptions.class);
        defaultBotOptions.setProxyHost(proxyHost);
        defaultBotOptions.setProxyType(proxyType);
        defaultBotOptions.setProxyPort(proxyPort);
        TelegramMain telegramMain=new TelegramMain(defaultBotOptions);
        telegramMain.setBotToken(botToken);
        telegramMain.setBotUserName(botUserName);
        telegramMain.setBotWebhookPath(botWebhookPath);
        System.out.println(botToken+botUserName+botWebhookPath);
        return telegramMain;
    }
    @Bean
    public ManageNewMessage MyManageNewMessage(){
        ManageNewMessage manageNewMessage=new ManageNewMessage(MySuperTelegramBot());
        return manageNewMessage;

    }
}
