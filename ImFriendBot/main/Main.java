//import Bot;
//import MessageReceiver;
//import MessageSender;
import constants.CONSTANTS;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.api.methods.send.SendMessage;

public class Main {
    public static Bot bot;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        Bot friend_bot = new Bot("ImFriendBot", "111AAAAA");

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
        receiver.setPriority(CONSTANTS.PRIORITY_FOR_RECEIVER);
        receiver.start();

        Thread sender = new Thread(messageSender);
        sender.setDaemon(true);
        sender.setName("MsgSender");
        sender.setPriority(CONSTANTS.PRIORITY_FOR_SENDER);
        sender.start();

        friend_bot.sendStartReport();

    }
}
