//import Bot;
//import Command;
//import ParsedCommand;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

import java.util.Random;

public class SystemHandler extends AbstractHandler {

    private static final Logger log = Logger.getLogger(SystemHandler.class);
    private static final String END_LINE = "\n";
    public SystemHandler(Bot bot) {
        super(bot);
    }
    @Override
    public String operate(String chatId, ParsedCommand parsedCommand, Update update) {
        //SendMessage sendMessage = new SendMessage();
        Command command = parsedCommand.getCommand();

        switch (command) {
            case START:
                bot.sendQueue.add(getMessageStart(chatId));
                //SendMessage sendMessage = new SendMessage();
                //Keyboard.setButtons(sendMessage, chatId);
                break;
            case HELP:
                bot.sendQueue.add(getMessageHelp(chatId));
                break;
            case ID:
                return "Твой телеграм ID: " + update.getMessage().getFrom().getId();
            case STICKER:
                return "ID стикера: " + parsedCommand.getText();
            case HELLO:
                Random random1 = new Random();
                int k1=random1.nextInt(10);
                //String[] helloArray;
                //helloArray = DatabaseA.helloArray;
                DatabaseA.setHelloArray(DatabaseA.helloArray);
                return DatabaseA.helloArray[k1];
            case MOTIV:
                Random random2 = new Random();
                int k2=random2.nextInt(10);
                DatabaseA.setMotivArray(DatabaseA.motivArray);
                return DatabaseA.motivArray[k2];
           /* case MUSIC:
                Random random3 = new Random();
                int k3 = random3.nextInt(25);
                DatabaseA.setMusicArray(DatabaseA.musicArray);
                return DatabaseA.musicArray[k3];*/
            case MUSIC:
                bot.sendQueue.add(getMessageMusic(chatId));
                break;
            case PIC:
                Random random4 = new Random();
                int k4 = random4.nextInt(20);
                DatabaseA.setPicArray(DatabaseA.picArray);
                return DatabaseA.picArray[k4];
            default: return "";
        }
        return "";
    }

    protected static SendMessage getMessageHelp(String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableMarkdown(true);

        StringBuilder text = new StringBuilder();
        text.append("*This is help message*").append(END_LINE).append(END_LINE);
        text.append("[/start](/start) - показать start message").append(END_LINE);
        text.append("[/help](/help) - показать help message").append(END_LINE);
        text.append("[/id](/id) - прислать твой ID в telegram ").append(END_LINE);
        text.append("/*notify* _time-in-sec_  - отправить напоминание через заданное количество секунд ").append(END_LINE);
        text.append("[/hello](/hello) - поздороваться на рандомном языке :) ").append(END_LINE);
        text.append("[/motiv](/motiv) - прислать мотивационное сообщение с:").append(END_LINE);
        text.append("/*emoji* :) - показать расшифровку смайликов (пиши их сразу после команды)").append(END_LINE);
        text.append("[/music](/music) - посоветовать рандомного музыкального исполнителя").append(END_LINE);
        text.append("[/pic](/pic) - прислать точечную картинку (как в 2012!)\nЧтоб ее было лучше видно, разверни экран.").append(END_LINE);
        sendMessage.setText(text.toString());
        return sendMessage;
    }

    private SendMessage getMessageStart(String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableMarkdown(true);
        StringBuilder text = new StringBuilder();
        text.append("Привет! Я -  *").append(bot.getBotName()).append("*").append(END_LINE);
        text.append("Мой автор: `@g1455_0f_p0rtw1n3`").append(END_LINE);
        text.append("В последующих релизах я буду уметь советовать фильмы.").append(END_LINE);
        text.append("Все мои команды можно увидеть, набрав [/help](/help)");
        sendMessage.setText(text.toString());
        return sendMessage;
    }

    protected static SendMessage getMessageMusic(String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableMarkdown(true);
        Random random = new Random();
        int k = random.nextInt(25);
        DatabaseA.setMusicArray(DatabaseA.musicArray);
        String text = DatabaseA.musicArray[k];
        sendMessage.setText(text);
        return sendMessage;
    }

    protected static SendMessage getMessageActionFilm(String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableMarkdown(true);
        Random random = new Random();
        int k = random.nextInt(15);
        DatabaseA.setActionFilmArray(DatabaseA.actionFilmArray);
        String text = DatabaseA.actionFilmArray[k];
        sendMessage.setText(text);
        return sendMessage;
    }

    protected static SendMessage getMessageHorrorFilm(String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableMarkdown(true);
        Random random = new Random();
        int k = random.nextInt(15);
        DatabaseA.setHorrorFilmArray(DatabaseA.horrorFilmArray);
        String text = DatabaseA.horrorFilmArray[k];
        sendMessage.setText(text);
        return sendMessage;
    }

    protected static SendMessage getMessageComedyFilm(String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableMarkdown(true);
        Random random = new Random();
        int k = random.nextInt(15);
        DatabaseA.setComedyFilmArray(DatabaseA.comedyFilmArray);
        String text = DatabaseA.comedyFilmArray[k];
        sendMessage.setText(text);
        return sendMessage;
    }

    protected static SendMessage getMessageRomanFilm(String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableMarkdown(true);
        Random random = new Random();
        int k = random.nextInt(15);
        DatabaseA.setRomanFilmArray(DatabaseA.romanFilmArray);
        String text = DatabaseA.romanFilmArray[k];
        sendMessage.setText(text);
        return sendMessage;
    }
}