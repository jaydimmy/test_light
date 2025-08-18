package io.testomat.test_light.selenide;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.test_light.helpers.EnvHelper;
import io.testomat.test_light.selenide.web.pages.SignInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.testomat.test_light.helpers.EnvHelper.getEnvValue;

@ExtendWith({TextReportExtension.class})
public class BaseTest {

    static {
        EnvHelper.configure();
    }

    public static final String validEmail = getEnvValue("USER_EMAIL");
    public static final String validPassword = getEnvValue("USER_PASSWORD");

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
