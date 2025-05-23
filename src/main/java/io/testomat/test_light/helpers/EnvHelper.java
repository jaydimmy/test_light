package io.testomat.test_light.helpers;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvHelper {
    private static final Dotenv env = Dotenv.load();

    public static String getBaseUrl() {
        return env.get("BASE_URL");
    }

    public static String getUserEmail() {
        return env.get("USER_EMAIL");
    }

    public static String getUserPassword() {
        return env.get("USER_PASSWORD");
    }
}