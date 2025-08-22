package io.testomat.test_light.resurses.helpers;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

public class EnvHelper {
    private EnvHelper() {
    }

    public static void configure() {
        Configuration.baseUrl = getEnvValue("BASE_URL");
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1720x1440";
    }

    public static String getEnvValue(String key) {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get(key);
    }
}