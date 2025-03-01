package com.agro.project.component;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import jakarta.annotation.PostConstruct;

@Component
public class BotInitializer {

    private final RegistrationBot registrationBot;

    // Constructor Injection
    public BotInitializer(RegistrationBot registrationBot) {
        this.registrationBot = registrationBot;
    }

    @PostConstruct
    public void init() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(registrationBot); // ✅ Injected Instance
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
