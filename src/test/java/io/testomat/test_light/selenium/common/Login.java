package io.testomat.test_light.selenium.common;

import io.testomat.test_light.helpers.EnvHelper;
import io.testomat.test_light.selenium.web.pages.SignInPageSelenium;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.test_light.selenium.web.common.WebDriverProvider.driver;

public class Login implements BeforeAllCallback {
    public static final String validEmail = EnvHelper.getUserEmail();
    public static final String validPassword = EnvHelper.getUserPassword();

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        driver().get("https://app.testomat.io");
        new SignInPageSelenium().login(validEmail, validPassword);
    }
}
