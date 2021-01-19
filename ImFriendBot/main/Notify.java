import constants.CONSTANTS;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendSticker;

public class Notify implements Runnable {
    private static final Logger log = Logger.getLogger(Notify.class);

    Bot bot;
    long delayInMillisec;
    String chatID;

    public Notify(Bot bot, String chatID, long delayInMillisec) {
        this.bot = bot;
        this.chatID = chatID;
        this.delayInMillisec = delayInMillisec;
        log.debug("CREATE. " + toString());
    }

    @Override
    public void run() {
        log.info("RUN. " + toString());
        bot.sendQueue.add(getFirstMessage());
        try {
            Thread.sleep(delayInMillisec);
            bot.sendQueue.add(getSecondSticker());
            bot.sendQueue.add(getSecondMessage());
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        log.info("FINISH. " + toString());
    }

    private SendMessage getFirstMessage() {
        return new SendMessage(chatID, "Я отправлю уведомление через " + delayInMillisec / CONSTANTS.MILLISEC_IN_SEC + " сек");
    }

    private SendSticker getSecondSticker() {
        SendSticker sendSticker = new SendSticker();
        sendSticker.setSticker("CAACAgIAAxkBAAJkzV7GX3UtxMqfsjuukN2IW4AmVvD8AAKeAAP3AsgPGPPKJBk_qlsZBA");
        sendSticker.setChatId(chatID);
        return sendSticker;
    }

    private SendMessage getSecondMessage() {
        return new SendMessage(chatID, "Это напоминание. Спасибо за использование :)");
    }
}
