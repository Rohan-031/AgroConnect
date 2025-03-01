package com.agro.project.component;

import com.agro.project.entity.Buyer;
import com.agro.project.entity.Seller;
import com.agro.project.Repository.BuyerRepository;
import com.agro.project.Repository.SellerRepository;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

@Component
public class RegistrationBot extends TelegramLongPollingBot {

    private final BuyerRepository buyerRepository;
    private final SellerRepository sellerRepository;

    private final Map<Long, String> userStates = new HashMap<>();
    private final Map<Long, Object> tempUserData = new HashMap<>();

    // Constructor Injection
    public RegistrationBot(BuyerRepository buyerRepository, SellerRepository sellerRepository) {
        this.buyerRepository = buyerRepository;
        this.sellerRepository = sellerRepository;
    }

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
        sendMessage(chatId, "Welcome! Are you a Buyer or a Seller? (Type 'Buyer' or 'Seller')");
        userStates.put(chatId, "ASK_ROLE");
    }

    private void processUserInput(Long chatId, String userMessage) {
        String currentState = userStates.get(chatId);

        if (currentState == null) {
            sendMessage(chatId, "Type /start to begin registration.");
            return;
        }

        switch (currentState) {
            case "ASK_ROLE":
                if (userMessage.equalsIgnoreCase("Buyer")) {
                    Buyer buyer = new Buyer();
                    buyer.setChatId(chatId);
                    tempUserData.put(chatId, buyer);
                } else if (userMessage.equalsIgnoreCase("Seller")) {
                    Seller seller = new Seller();
                    seller.setChatId(chatId);
                    tempUserData.put(chatId, seller);
                } else {
                    sendMessage(chatId, "Invalid choice! Please type 'Buyer' or 'Seller'.");
                    return;
                }

                sendMessage(chatId, "Great! Please enter your name:");
                userStates.put(chatId, "ASK_NAME");
                break;

            case "ASK_NAME":
                Object userObject = tempUserData.get(chatId);
                if (userObject instanceof Buyer) {
                    ((Buyer) userObject).setName(userMessage);
                } else if (userObject instanceof Seller) {
                    ((Seller) userObject).setName(userMessage);
                }

                sendMessage(chatId, "Now enter your email:");
                userStates.put(chatId, "ASK_EMAIL");
                break;

            case "ASK_EMAIL":
                if (!userMessage.contains("@")) {
                    sendMessage(chatId, "Invalid email format! Please enter a valid email:");
                    return;
                }

                userObject = tempUserData.get(chatId);
                if (userObject instanceof Buyer) {
                    ((Buyer) userObject).setEmail(userMessage);
                } else if (userObject instanceof Seller) {
                    ((Seller) userObject).setEmail(userMessage);
                }

                sendMessage(chatId, "Now enter your mobile number:");
                userStates.put(chatId, "ASK_MOBILE");
                break;

            case "ASK_MOBILE":
                if (!userMessage.matches("\\d{10}")) {
                    sendMessage(chatId, "Invalid mobile number! Enter a 10-digit number:");
                    return;
                }

                userObject = tempUserData.get(chatId);
                if (userObject instanceof Buyer) {
                    ((Buyer) userObject).setMobile(userMessage);
                    buyerRepository.save((Buyer) userObject);
                    sendMessage(chatId, "🎉 Your Registration Id: "+((Buyer) userObject).getId()+" Registration successful as a Buyer! 🎉");
                } else if (userObject instanceof Seller) {
                    ((Seller) userObject).setMobile(userMessage);
                    sellerRepository.save((Seller) userObject);
                    sendMessage(chatId, "🎉 Your Registration Id:"+ ((Seller) userObject).getId()+" Registration successful as a Seller! 🎉");
                }

                // Clear stored data
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
        return "Agro_Connection_bot"; // Keeping bot username as it was before
    }

    @Override
    public String getBotToken() {
        return ""; // Keeping bot token logic as it was before
    }
}
