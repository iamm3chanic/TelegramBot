import org.telegram.telegrambots.api.methods.send.SendSticker;

public enum Stickers {
    OK_FISH("CAACAgIAAxkBAAJkzV7GX3UtxMqfsjuukN2IW4AmVvD8AAKeAAP3AsgPGPPKJBk_qlsZBA")
    ;

    String stickerId;

    Stickers(String stickerId) {
        this.stickerId = stickerId;
    }

    public SendSticker getSendSticker(String chatId) {
        if ("".equals(chatId)) throw new IllegalArgumentException("ChatId cant be null");
        SendSticker sendSticker = getSendSticker();
        sendSticker.setChatId(chatId);
        return sendSticker;
    }

    public SendSticker getSendSticker() {
        SendSticker sendSticker = new SendSticker();
        sendSticker.setSticker(stickerId);
        return sendSticker;
    }
}