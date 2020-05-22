//import Bot;
//import MessageReceiver;
//import MessageSender;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.api.methods.send.SendMessage;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    private static final int PRIORITY_FOR_SENDER = 1;
    private static final int PRIORITY_FOR_RECEIVER = 3;
    private static final String BOT_ADMIN = "358377512";
    //private Bot bot;
    //private String chatId;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        Bot friend_bot = new Bot("ImFriendBot", "1092610100:AAFp3x4o6jAXbq5V88NysRgxfhUyCoMfZNA");

        MessageReceiver messageReceiver = new MessageReceiver(friend_bot);
        MessageSender messageSender = new MessageSender(friend_bot);

        friend_bot.botConnect();
       // SendMessage sendMessage = new SendMessage();

        Thread receiver = new Thread(messageReceiver);
        receiver.setDaemon(true);
        receiver.setName("MsgReceiver");
        receiver.setPriority(PRIORITY_FOR_RECEIVER);
        receiver.start();

        Thread sender = new Thread(messageSender);
        sender.setDaemon(true);
        sender.setName("MsgSender");
        sender.setPriority(PRIORITY_FOR_SENDER);
        sender.start();

        sendStartReport(friend_bot);
        //setButtons();
    }

/*
    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     *
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    /**
     * Метод для настройки сообщения и его отправки.
     * param chatId id чата
     * param s Строка, которую необходимот отправить в качестве сообщения.
     *
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);

        sendMessage(sendMessage);

    }*/
    /*private synchronized void setButtons() {
        SendMessage sendMessage = null;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем
        // кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Музыка"));
        keyboardFirstRow.add(new KeyboardButton("Фильмы"));
        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Помощь"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }*/
    /*public String getMessage(String message) {
        if (message.equals("Привет") || message.equals("Меню")) {
            bot.sendQueue.add(SystemHandler.getMessageHelp(chatId));
            return "";
        }

        if (message.equals("Спасибо")) {
            return "Рад помочь!";
        }

        return message;
    }*/

    private static void sendStartReport(Bot bot) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(BOT_ADMIN);
        sendMessage.setText("Деплой произошел успешно! Я запустился.");
        bot.sendQueue.add(sendMessage);
    }
}