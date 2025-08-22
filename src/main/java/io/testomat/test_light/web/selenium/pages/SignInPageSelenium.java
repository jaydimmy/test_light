package io.testomat.test_light.web.selenium.pages;


import static io.testomat.test_light.web.selenium.common.Elements.find;

public class SignInPageSelenium {

    public void login(String email, String password) {
        find("#content-desktop #user_email").sendKeys(email);
        find("#content-desktop #user_password").sendKeys(password);
        find("#content-desktop input[type='submit']").click();
    }
}
