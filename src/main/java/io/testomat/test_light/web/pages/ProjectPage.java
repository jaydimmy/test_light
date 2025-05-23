package io.testomat.test_light.web.pages;

import static io.testomat.test_light.web.pages.BasePage.verifyPageIsLoaded;

public class ProjectPage {

    public void isLoaded(String targetProjectName) {
        verifyPageIsLoaded(".main-app", targetProjectName);
    }
}
