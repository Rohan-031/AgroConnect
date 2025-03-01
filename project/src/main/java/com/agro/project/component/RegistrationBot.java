package com.agro.project.component;

import com.agro.project.entity.User;
import com.agro.project.Repository.TelegramUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;
import com.agro.project.secrets.BotToken;

@Component
public class RegistrationBot extends TelegramLongPollingBot {

//    @Autowired
    private TelegramUserRepository userRepository;

    public RegistrationBot(TelegramUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final Map<Long, String> userStates = new HashMap<>();
    private final Map<Long, User> tempUserData = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            String userMessage = update.getMessage().getText();

            if (userMessage.equalsIgnoreCase("/start")) {
                startRegistration(chatId);
            } else {
                processUserInput(chatId, userMessage);
            }
        }
    }

    private void startRegistration(Long chatId) {
        sendMessage(chatId, "Welcome! Let's register. Please enter your name:");
        userStates.put(chatId, "ASK_NAME");
    }

    private void processUserInput(Long chatId, String userMessage) {
        String currentState = userStates.get(chatId);

        if (currentState == null) {
            sendMessage(chatId, "Type /start to begin registration.");
            return;
        }

        switch (currentState) {
            case "ASK_NAME":
                User user = new User();
                user.setChatId(chatId);
                user.setName(userMessage);
                tempUserData.put(chatId, user);

                sendMessage(chatId, "Great! Now enter your email:");
                userStates.put(chatId, "ASK_EMAIL");
                break;

            case "ASK_EMAIL":
                if (!userMessage.contains("@")) {
                    sendMessage(chatId, "Invalid email format! Please enter a valid email:");
                    return;
                }

                tempUserData.get(chatId).setEmail(userMessage);
                sendMessage(chatId, "Now enter your mobile number:");
                userStates.put(chatId, "ASK_MOBILE");
                break;

            case "ASK_MOBILE":
                if (!userMessage.matches("\\d{10}")) {
                    sendMessage(chatId, "Invalid mobile number! Enter a 10-digit number:");
                    return;
                }

                User completedUser = tempUserData.get(chatId);
                completedUser.setMobile(userMessage);
                userRepository.save(completedUser);

                sendMessage(chatId, "Registration successful! 🎉");
                userStates.remove(chatId);
                tempUserData.remove(chatId);
                break;
        }
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Agro_Connection_bot"; // Replace with your bot's username
    }

    @Override
    public String getBotToken() {
        return "547457354754754"; // Replace with your bot token
    }
}
