import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class Keyboard {
    private static Bot bot;

    public static void setBot(Bot bot) {
        Keyboard.bot = bot;
    }

    static ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    //private static String s;
    //private static String chatId;
 //Bot bot;
 //String s;
 //SendMessage message = new SendMessage();

 /*
 * Метод для настройки сообщения и его отправки.
 * @param chatId id чата
 * @param s Строка, которую необходимот отправить в качестве сообщения.
 *
public static synchronized void sendMsg(String chatId, String s) {
    SendMessage sendMessage = new SendMessage();
    sendMessage.enableMarkdown(true);
    sendMessage.setChatId(chatId);
    sendMessage.setText(s);
    bot.sendMsg(chatId,s);
}*/

    public static synchronized void setButtons(SendMessage sendMessage, String chatId) {
        //SendMessage sendMessage = new SendMessage();
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

    }
    public static synchronized void setButtonsLocal(SendMessage sendMessage, String chatId) {
        //SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        // Создаем список строк клавиатуры
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
       // keyboardFirstRow.clear();

        keyboardFirstRow.add(new KeyboardButton("Боевик"));
        keyboardFirstRow.add(new KeyboardButton("Комедия"));

        KeyboardRow keyboardSecondRow = new KeyboardRow();
       // keyboardSecondRow.clear();
        keyboardSecondRow.add(new KeyboardButton("Ужасы"));
        keyboardSecondRow.add(new KeyboardButton("Романтика"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public static void clear(ReplyKeyboardMarkup replyKeyboardMarkup) {
        // Создаем список строк клавиатуры
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        for(KeyboardRow keyboardRow : keyboard)
        keyboardRow.clear();
       /* KeyboardRow keyboardSecondRow = new KeyboardRow();
         keyboardSecondRow.clear();*/
    }
}
