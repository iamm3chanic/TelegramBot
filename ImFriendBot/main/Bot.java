//import javafx.scene.input.KeyEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.stickers.Sticker;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@NoArgsConstructor
public class Bot extends TelegramLongPollingBot {
    private static final Logger log = Logger.getLogger(Bot.class);

    @Setter
    @Getter
    private String botName;

    @Setter
    private String botToken;

    public final Queue<Object> sendQueue = new ConcurrentLinkedQueue<>();
    public final Queue<Object> receiveQueue = new ConcurrentLinkedQueue<>();
    private Sticker sticker;

    public Bot(String botName, String botToken) {
        this.botName = botName;
        this.botToken = botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.debug("Receive new Update. updateID: " + update.getUpdateId());
        receiveQueue.add(update);
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param s Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        if (!s.startsWith("/")) {
            if((s.contains("ривет"))||(s.contains("Хай"))||(s.contains("доров"))||(s.contains("ello"))||(s.contains("hi"))||(s.contains("Hi"))) {
                sendMessage.setText("Привет!");
            }
            else if((s.contains("пасиб"))||(s.contains("Пасиб"))||(s.contains("лагодар"))) {
                sendMessage.setText("Рад помочь!");
            }
            else if(Objects.equals(sendMessage, sticker))  {
                ParsedCommand parsedCommand = new ParsedCommand(Command.STICKER,"");
                sendMessage.setText("ID стикера: "+ parsedCommand.getText());
            }
            else
                sendMessage.setText("Твоё сообщение: "+s);
        }
        else {
            new SystemHandler(Main.bot);
        }
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            //log.log(SEVERE, "Exception: ", e.toString());
        }
    }

    @Override
    public String getBotUsername() {
        log.debug("Bot name: " + botName);
        return botName;
    }

    @Override
    public String getBotToken() {
        log.debug("Bot token: " + botToken);
        return botToken;
    }

    public void botConnect() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this);
            log.info("[STARTED] TelegramAPI. Bot Connected. Bot class: " + this);
        } catch (TelegramApiRequestException e) {
            int RECONNECT_PAUSE = 10000;
            log.error("Cant Connect. Pause " + RECONNECT_PAUSE / 1000 + "sec and try again. Error: " + e.getMessage());
            try {
                Thread.sleep(RECONNECT_PAUSE);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
                return;
            }
            botConnect();
        }
    }

    public String getBotName() {
        return botName;
    }
 }

//        Keyboard.setButtons(sendMessage);
