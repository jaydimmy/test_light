package io.testomat.test_light.helpers;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

public class EnvHelper {
    private static final Dotenv env = Dotenv.load();

    public static void configure() {
        Configuration.baseUrl = env.get("BASE_URL");
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1720x1440";
    }

    public static String getUserEmail() {
        return env.get("USER_EMAIL");
    }

    public static String getUserPassword() {
        return env.get("USER_PASSWORD");
    }
}