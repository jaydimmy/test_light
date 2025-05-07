package io.testomat.test_light;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.testomat.test_light.Utils.findVisibleElementByChainedId;

public class LoginFormHelper {

    private static final String CONTENT_DESKTOP = "content-desktop";
    private static final String EMAIL = "jaydimmy@gmail.com";
    private static final String PASSWORD = "vUe4sN3C!bvrcZJ";

    private static final Logger logger = LoggerFactory.getLogger(LoginFormHelper.class);

    public static void checkLoginFormIsLoaded() {
        logger.info("Checking if the login form is loaded");
        $(By.id(CONTENT_DESKTOP)).shouldBe(visible).shouldNotBe(empty);
        logger.info("Login form is loaded successfully.");
    }

    public static void setUserEmail() {
        logger.info("Setting user email");
        SelenideElement userEmailInput = findVisibleElementByChainedId(CONTENT_DESKTOP, "user_email");
        userEmailInput.clear();
        userEmailInput.sendKeys(EMAIL);
        userEmailInput.shouldHave(value(EMAIL));
        logger.info("User email set to: {}", EMAIL);
    }

    public static void setUserPassword() {
        logger.info("Setting user password");
        SelenideElement userPasswordInput = findVisibleElementByChainedId(CONTENT_DESKTOP, "user_password");
        userPasswordInput.clear();
        userPasswordInput.sendKeys(PASSWORD);
        userPasswordInput.shouldHave(value(PASSWORD));
        logger.info("User password set successfully.");
    }

    public static void checkRememberMe() {
        logger.info("Checking 'Remember Me' checkbox");
        SelenideElement rememberMeCheckbox = findVisibleElementByChainedId(CONTENT_DESKTOP, "user_remember_me");
        rememberMeCheckbox.click();
        rememberMeCheckbox.shouldBe(checked);
        logger.info("'Remember Me' checkbox is checked.");
    }

    public static void clickSignInButton() {
        logger.info("Clicking the Sign In button");
        $("#content-desktop input[type='submit']")
                .shouldBe(visible)
                .click();
        logger.info("Sign In button clicked.");
    }
}