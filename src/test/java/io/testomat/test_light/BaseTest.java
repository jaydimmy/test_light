package io.testomat.test_light;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;
import static io.testomat.test_light.LoginFormHelper.checkLoginFormIsLoaded;
import static io.testomat.test_light.LoginFormHelper.checkRememberMe;
import static io.testomat.test_light.LoginFormHelper.clickSignInButton;
import static io.testomat.test_light.LoginFormHelper.setUserEmail;
import static io.testomat.test_light.LoginFormHelper.setUserPassword;
import static io.testomat.test_light.Utils.getInitialPageUrl;
import static io.testomat.test_light.Utils.verifyLoaderIsNotVisible;
import static io.testomat.test_light.Utils.verifyUrlChange;

public class BaseTest {

    @BeforeAll
    public static void  login() {
        open("https://app.testomat.io");
        checkLoginFormIsLoaded();
        getInitialPageUrl();
        setUserEmail();
        setUserPassword();
        checkRememberMe();
        clickSignInButton();
        verifyLoaderIsNotVisible();
        verifyUrlChange();
 }
}
