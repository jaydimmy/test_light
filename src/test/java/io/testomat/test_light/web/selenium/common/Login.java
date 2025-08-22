package io.testomat.test_light.web.selenium.common;

import io.testomat.test_light.resurses.helpers.EnvHelper;
import io.testomat.test_light.web.selenium.pages.SignInPageSelenium;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.test_light.web.selenium.common.WebDriverProvider.driver;

public class Login implements BeforeAllCallback {
    public static final String validEmail = EnvHelper.getEnvValue("USER_EMAIL");
    public static final String validPassword = EnvHelper.getEnvValue("USER_PASSWORD");

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        driver().get("https://app.testomat.io");
        new SignInPageSelenium().login(validEmail, validPassword);
    }
}
