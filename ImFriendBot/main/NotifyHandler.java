//import Notify;
//import Bot;
//import ParsedCommand;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.objects.Update;

public class NotifyHandler extends AbstractHandler {
    //private static final Logger log = Logger.getLogger(NotifyHandler.class);
    private static final Logger log = Logger.getLogger(NotifyHandler.class);
    private final int MILLISEC_IN_SEC = 1000;
    private String WRONG_INPUT_MESSAGE =  "Неверный ввод. Время задается целым числом, большим 0";
    public NotifyHandler(Bot bot) {
        super(bot);
    }

    @Override
    public String operate(String chatId, ParsedCommand parsedCommand, Update update) {
        String text = parsedCommand.getText();
        if ("".equals(text))
            return "Обозначь таймер для уведомления в секундах. Например так:\n" +
                    "/notify 30";
        long timeInSec;
       // return WRONG_INPUT_MESSAGE;// "Неверный ввод. Время задается целым числом, большим 0";
        try {
            timeInSec = Long.parseLong(text.trim());
        } catch (NumberFormatException e) {
            return WRONG_INPUT_MESSAGE;
        }
        if (timeInSec > 0) {
           // int MILLISEC_IN_SEC = 1000;
            Thread thread = new Thread(new Notify(bot, chatId, timeInSec * MILLISEC_IN_SEC));
            thread.start();
        } else return WRONG_INPUT_MESSAGE;
        return "";
    }
}