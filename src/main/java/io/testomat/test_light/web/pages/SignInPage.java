package io.testomat.test_light.web.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;


public class SignInPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(SignInPage.class);
    public static final String SIGN_IN = "Sign In";
    public static final String COMMON_FLASH_INFO = ".common-flash-info";

    private final SelenideElement contentDesktopContainer = $(CONTENT_DESKTOP);
    private final SelenideElement userEmailInput = contentDesktopContainer.find(By.id("user_email"));
    private final SelenideElement userPasswordInput = contentDesktopContainer.find(By.id("user_password"));
    private final SelenideElement rememberMeCheckbox = contentDesktopContainer.find(By.id("user_remember_me"));
    private final SelenideElement signInButton = contentDesktopContainer.find(By.cssSelector("input[type='submit']"));

    public void open() {
        logger.info("Opening login page");
        Selenide.open("/users/sign_in");
    }

    public void isLoaded() {
        verifyPageIsLoaded(CONTENT_DESKTOP, SIGN_IN);
    }

    public void enterUserEmail(String userEmail) {
        logger.info("Entering user email: {}", userEmail);
        userEmailInput.setValue(userEmail);
        userEmailInput.shouldHave(value(userEmail));
    }

    public void enterUserPassword(String userPassword) {
        logger.info("Entering user password");
        userPasswordInput.setValue(userPassword);
        userPasswordInput.shouldHave(value(userPassword));
    }

    public void checkRememberMe() {
        logger.info("Checking 'Remember Me' checkbox");
        rememberMeCheckbox.shouldNotBe(checked);
        rememberMeCheckbox.click();
        rememberMeCheckbox.shouldBe(checked);
    }

    public void clickSignInButton() {
        logger.info("Clicking the Sign In button");
        signInButton.click();
    }

    public void verifyInvalidEmailOrPasswordMessage() {
        verifyMessage(CONTENT_DESKTOP, COMMON_FLASH_INFO,
                "Invalid email or password.");
    }

    public void verifyYouMustBeLoggedMessage() {
        verifyMessage(CONTENT_DESKTOP, COMMON_FLASH_INFO,
                "You must be logged in to access this page");
    }

    public void login(String email, String password) {
        open();
        verifyPageIsLoaded(CONTENT_DESKTOP, SIGN_IN);
        enterUserEmail(email);
        enterUserPassword(password);
        checkRememberMe();
        clickSignInButton();
    }
}