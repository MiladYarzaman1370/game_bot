package com.example.bot.gameBot;


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
                SendMessage sendMessage=new SendMessage();
                //sendMessage.setText("کدام گزینه صحیح می باشد؟\n "+"1:میلاد\n"+"2:حسین\n"+"3:فواد");
               /* sendMessage.setText("پیام آیات 15 و 16 سوره هود چیست؟         \n" +
                        "\n" +
                        "الف) کسانی که تنها هدفشان زندگى دنیا و زرق و برق و زینت آن باشد، به آن نخواهند رسید.    \n" +
                        "\n" +
                        "ب) کسانی که تنها هدفشان زندگى دنیا و زرق و برق و زینت آن باشد، خداوند ثمره تلاششان را به آنان خواهد داد (دنیا و زینت هایش را به آنان می دهد) اما در آخرت چیزی جز آتش برایشان نخواهد بود        \n" +
                        "\n" +
                        "ج) کسانی که تنها هدفشان زندگی دنیا باشند در همین دنیا آنان را عذابی سخت می کنیم     \n" +
                        "\n" +
                        "د) الف و ج\n" +
                        "\n" +
                        "\n" +
                        "\n"
                        );*/
                sendMessage.setParseMode(ParseMode.HTML);
                sendMessage.setText("<a href='https://www.google.com'>milad</a><input type=\"radio\" value=\"male\">\n" +
                        "<label for=\"male\">Male</label><br>\n" );

                sendMessage.setChatId(update.getMessage().getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                markup = new InlineKeyboardMarkup();
                final List<List<InlineKeyboardButton>> keyboard = ((InlineKeyboardMarkup) markup).getKeyboard();
                for (int i = 0; i < 4; i++)
                {
                    if (keyboard.isEmpty() || (keyboard.get(keyboard.size() - 1).size() >= 3))
                    {
                        keyboard.add(new ArrayList<>());
                    }
                    keyboard.get(keyboard.size() - 1).add(new InlineKeyboardButton().setText("🔘 گزینه:#" + (i + 1)).setCallbackData("Button callback " + (i + 1)));
                }
            }
            else if (message.getText().startsWith("/keyboard"))
            {
                markup = new ReplyKeyboardMarkup();
                final List<KeyboardRow> keyboard = ((ReplyKeyboardMarkup) markup).getKeyboard();
                for (int i = 0; i < 9; i++)
                {
                    if (keyboard.isEmpty() || (keyboard.get(keyboard.size() - 1).size() >= 3))
                    {
                        keyboard.add(new KeyboardRow());
                    }
                    keyboard.get(keyboard.size() - 1).add(new KeyboardButton().setText("🔘 Button #" + (i + 1)));
                }
            }
            final SendMessage msg = new SendMessage();
            msg.setChatId(Long.toString(message.getChat().getId()));
            msg.setText("Your text here");
            msg.setReplyToMessageId(message.getMessageId());
            msg.setReplyMarkup(markup);
            try
            {
                execute(msg);
            }
            catch (TelegramApiException e)
            {
               // LOGGER.warn("Failed to execute SendMessage: ", e);
                e.printStackTrace();
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
