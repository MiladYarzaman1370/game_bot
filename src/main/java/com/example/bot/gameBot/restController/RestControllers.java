package com.example.bot.gameBot.restController;

import com.example.bot.gameBot.TelegramMain;
import com.example.bot.gameBot.services.ManageNewMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.logging.Logger;

@RestController
public class RestControllers {

    private final ManageNewMessage manageNewMessage;
    RestControllers(ManageNewMessage manageNewMessage){
        this.manageNewMessage=manageNewMessage;
    }
   @RequestMapping("/bt")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
       System.out.println(update.getMessage().getText());
       return manageNewMessage.manageUpdate(update);
   }
  @RequestMapping("/print")
    public String in(){
      System.out.println("call print func in controller.");
       return "print is ok";
   }
}
