package io.testomat.test_light.selenide;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.test_light.helpers.EnvHelper;
import io.testomat.test_light.selenide.web.pages.SignInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith({TextReportExtension.class})
public class BaseTest {

    static {
        EnvHelper.configure();
    }

    public static final String validEmail = EnvHelper.getUserEmail();
    public static final String validPassword = EnvHelper.getUserPassword();

    @BeforeEach
    public void setUp() {
        new SignInPage()
                .login(validEmail, validPassword);
 }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

}
