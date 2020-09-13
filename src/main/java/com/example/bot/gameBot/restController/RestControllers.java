package com.example.bot.gameBot.restController;

import com.example.bot.gameBot.TelegramMain;
import com.example.bot.gameBot.services.ManageNewMessage;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestControllers {

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private final ManageNewMessage manageNewMessage;
    RestControllers(ManageNewMessage manageNewMessage){
        this.manageNewMessage=manageNewMessage;
    }
   @RequestMapping("/bt")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
       System.out.println(update.getMessage().getText());
       LOGGER.log(Level.INFO, "My first Log Message in onupdateRecive");
       return manageNewMessage.manageUpdate(update);
   }
  @RequestMapping("/print")
    public String in(){
      LOGGER.log(Level.INFO, "My first Log Message in print");

      System.out.println("call print func in controller.");
       return "print is ok";
   }
}
