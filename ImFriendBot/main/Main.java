//import Bot;
//import MessageReceiver;
//import MessageSender;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.api.methods.send.SendMessage;

public class Main {
   // private static final Logger log = Logger.getLogger(Main.class);
    private static final int PRIORITY_FOR_SENDER = 1;
    private static final int PRIORITY_FOR_RECEIVER = 3;
    private static final String BOT_ADMIN = "12345";
    public static Bot bot;
    //private Bot bot;
    //private String chatId;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        Bot friend_bot = new Bot("ImFriendBot", "tokentokentoken");

        MessageReceiver messageReceiver = new MessageReceiver(friend_bot);
        MessageSender messageSender = new MessageSender(friend_bot);
        //Keyboard keyboard = new Keyboard();

        //SendMessage sendMessage = new SendMessage();
        //Keyboard.setButtons(sendMessage);

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

    }


    private static void sendStartReport(Bot bot) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(BOT_ADMIN);
        sendMessage.setText("Деплой произошел успешно! Version normal2.");
        bot.sendQueue.add(sendMessage);
    }
}
