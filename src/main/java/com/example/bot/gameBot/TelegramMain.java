package com.example.bot.gameBot;


import com.example.bot.gameBot.services.CheckUserType;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;



import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

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
        //SendMessage message = new SendMessage() ;// Create a message object object
       /* if(update.getMessage()!=null && update.getMessage().hasText()){

            String message_text = update.getMessage().getText();

            long chat_id = update.getMessage().getChatId();
            System.out.println(update.getMessage().getFrom().getId()+update.getMessage().getFrom().getFirstName());
            SendMessage sendMessage = new SendMessage();


            // sendMessage.enableMarkdown(true);
            sendMessage.disableNotification();
            sendMessage.setChatId(chat_id);
            sendMessage.setText(message_text);
            Message m=new Message();
            try {
                execute(sendMessage);
                // m=execute(sendMessage);
                 //execute(sendDocument);

                System.out.println("****************onwebhook not exception******************");
            } catch (TelegramApiException e) {
                e.printStackTrace();
                System.out.println(m.getText());
            }



        }*/
        // We check if the update has a message and the message has text
        //simple inlin keyboard
      /*  if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (update.getMessage().getText().equals("/start")) {



                      message  .setChatId(chat_id)
                        .setText("You send /start");
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("Update message text").setCallbackData("update_msg_text"));
                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                    System.out.println(message_text);
            }

        } else if (update.hasCallbackQuery()) {
            // Set variables
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();

            if (call_data.equals("update_msg_text")) {
                String answer = "Updated message text";
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(answer);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }*/
        if (update.hasMessage() && update.getMessage().hasText())
        {



            final Message message = update.getMessage();
            ReplyKeyboard markup = null;
            if (message.getText().startsWith("/s"))
            {
                sendInlinKey(message);
            }
            else{
                SendMessage sendMessage=new SendMessage();
                sendMessage.setChatId(Long.toString(message.getChat().getId()));
                sendMessage.setText("invalid inpout");
                sendMessage.setReplyToMessageId(message.getMessageId());
                sendMessage.setReplyMarkup(markup);
                try
                {
                    execute(sendMessage);
                }
                catch (TelegramApiException e)
                {
                    // LOGGER.warn("Failed to execute SendMessage: ", e);
                    e.printStackTrace();
                }
            }


        }
        else if (update.hasCallbackQuery())
        {
            System.out.println(update.getCallbackQuery().getData());
            final AnswerCallbackQuery answer = new AnswerCallbackQuery();
            answer.setCallbackQueryId(update.getCallbackQuery().getId());
            answer.setText("You've clicked at the button: " + update.getCallbackQuery().getData());
            answer.setShowAlert(true);
            try
            {
                execute(answer);
            }
            catch (Exception e)
            {
                //LOGGER.warn("Failed to execute AnswerCallbackQuery: ", e);
                e.printStackTrace();
            }
        }
        return null;
    }

    private void sendInlinKey(Message message) {
        CheckUserType checkUserType=new CheckUserType();
        switch (checkUserType.check(message.getFrom().getId().toString())){
            case ConstVariable.USER_TYPE_ROOT:
                sendInlinKeyRootAdmin(message);
                break;
            case ConstVariable.USER_TYPE_ADMIN:
                sendInlinKeyAdmin(message);
                break;
            case ConstVariable.USER_TYPE_TEACHER:
                break;
            default:
                sendInlinKeyStudent(message);
        }
    }

    private void sendInlinKeyRootAdmin(Message message) {


        SendMessage sendMessage=new SendMessage();


        sendMessage.setChatId(message.getChatId());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        final List<List<InlineKeyboardButton>> keyboard = ((InlineKeyboardMarkup) markup).getKeyboard();

                keyboard.add(new ArrayList<>());

            keyboard.get(keyboard.size() - 1).add(new InlineKeyboardButton().setText("آزمون جدید").setCallbackData("آزمون جدید "));

        keyboard.add(new ArrayList<>());

        keyboard.get(keyboard.size() - 1).add(new InlineKeyboardButton().setText("مدیر جدید").setCallbackData("مدیر جدید "));
    }
    private void sendInlinKeyAdmin(Message message) {


        SendMessage sendMessage=new SendMessage();


        sendMessage.setChatId(message.getChatId());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        final List<List<InlineKeyboardButton>> keyboard = ((InlineKeyboardMarkup) markup).getKeyboard();

        keyboard.add(new ArrayList<>());

        keyboard.get(keyboard.size() - 1).add(new InlineKeyboardButton().setText("آزمون جدید").setCallbackData("آزمون جدید "));

    }
    private void sendInlinKeyStudent(Message message) {


        SendMessage sendMessage=new SendMessage();
        sendMessage.setText("لطفا گزینه مورد نظر را انتخاب کنید؟");

        sendMessage.setChatId(message.getChatId());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        final List<List<InlineKeyboardButton>> keyboard = ((InlineKeyboardMarkup) markup).getKeyboard();

        keyboard.add(new ArrayList<>());

        keyboard.get(keyboard.size() - 1).add(new InlineKeyboardButton().setText("شرکت در آزمون ").setCallbackData(" شرکت در آزمون  "));

        keyboard.add(new ArrayList<>());

        keyboard.get(keyboard.size() - 1).add(new InlineKeyboardButton().setText("مشاهده امتیاز").setCallbackData("مشاهده امتیاز  "));
    }


    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return botWebhookPath;
    }
}
