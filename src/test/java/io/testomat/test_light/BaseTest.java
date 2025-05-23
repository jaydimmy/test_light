package io.testomat.test_light;

import com.codeborne.selenide.Configuration;
import io.testomat.test_light.helpers.EnvHelper;
import io.testomat.test_light.web.pages.SignInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    static {
        Configuration.baseUrl = EnvHelper.getBaseUrl();
        Configuration.savePageSource = false;
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1720x1440";
    }

    private static final String USER_EMAIL = EnvHelper.getUserEmail();
    private static final String USER_PASSWORD = EnvHelper.getUserPassword();

    @BeforeEach
    public void setUp() {
        new SignInPage().login(USER_EMAIL, USER_PASSWORD);
 }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

}
