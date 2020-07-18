package com.example.bot.gameBot.restController;

import com.example.bot.gameBot.TelegramMain;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class RestControllers {
   private final TelegramMain telegramMain;
   RestControllers(TelegramMain telegramMain){
       this.telegramMain=telegramMain;
   }
   @RequestMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){

       return telegramMain.onWebhookUpdateReceived(update);
   }
  /* @RequestMapping("/")
    public String in(){
       return "is ok";
   }*/
}
