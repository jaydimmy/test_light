package io.testomat.test_light.web.selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static io.testomat.test_light.resurses.enums.PageTitles.SIGN_IN;


public class SignInPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(SignInPage.class);

    private final SelenideElement contentDesktopContainer = $(CONTENT_DESKTOP);
    private final SelenideElement userEmailInput = contentDesktopContainer.find(By.id("user_email"));
    private final SelenideElement userPasswordInput = contentDesktopContainer.find(By.id("user_password"));
    private final SelenideElement rememberMeCheckbox = contentDesktopContainer.find(By.id("user_remember_me"));
    private final SelenideElement signInButton = contentDesktopContainer.find(By.cssSelector("input[type='submit']"));
    private final SelenideElement commonFlashInfo = contentDesktopContainer.find(By.className("common-flash-info"));

    public SignInPage open() {
        logger.info("Opening login page");
        Selenide.open("/users/sign_in");
        logger.info("Login page opened");
        return this;
    }

    public SignInPage isLoaded() {
        verifyLoaderIsNotVisible();
        verifyPageIsLoaded(CONTENT_DESKTOP, SIGN_IN);
        logger.info("Sign In page is loaded");
        return this;
    }

    public SignInPage enterUserEmail(String userEmail) {
        logger.info("Entering user email: {}", userEmail);
        userEmailInput.setValue(userEmail);
        userEmailInput.shouldHave(value(userEmail));
        logger.info("User email entered");
        return this;
    }

    public SignInPage enterUserPassword(String userPassword) {
        logger.info("Entering user password");
        userPasswordInput.setValue(userPassword);
        userPasswordInput.shouldHave(value(userPassword));
        logger.info("User password entered");
        return this;
    }

    public SignInPage checkRememberMe() {
        logger.info("Checking 'Remember Me' checkbox");
        rememberMeCheckbox.shouldNotBe(checked);
        rememberMeCheckbox.click();
        rememberMeCheckbox.shouldBe(checked);
        logger.info("'Remember Me' checkbox checked");
        return this;
    }

    public SignInPage clickSignInButton() {
        logger.info("Clicking the Sign In button");
        signInButton.click();
        logger.info("Sign In button clicked");
        return this;
    }

    public SignInPage verifyInvalidEmailOrPasswordMessage() {
        verifyMessage(commonFlashInfo,
                "Invalid email or password.");
        return this;
    }

    public SignInPage verifyYouMustBeLoggedMessage() {
        verifyMessage(commonFlashInfo,
                "You must be logged in to access this page");
        return this;
    }

    public SignInPage login(String email, String password) {
        open();
        isLoaded();
        enterUserEmail(email);
        enterUserPassword(password);
        checkRememberMe();
        clickSignInButton();
        return this;
    }
}