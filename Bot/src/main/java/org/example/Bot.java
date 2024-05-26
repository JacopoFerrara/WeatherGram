package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;


public class Bot implements LongPollingSingleThreadUpdateConsumer {
    private String tokenAPI = "7454140776:AAHRMZ7D2d9nSf9TzR9yZ99Xty16rB7Thvg";
    private TelegramClient telegramClient = new OkHttpTelegramClient(tokenAPI);

    @Override
    public void consume(Update update){
        String command = (update.getMessage().getText());
        String idChat = String.valueOf(update.getMessage().getChatId());
        switch (command){
            case "/command1":
                String text = "Inserisci città";
                SendMessage sendMessage = new SendMessage(idChat, text);
                try {
                    telegramClient.execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                fetchCurrentWeather();
                break;
        }
    }


    public void fetchCurrentWeather(){
        ObjectMapper objectMapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();

    }
}
