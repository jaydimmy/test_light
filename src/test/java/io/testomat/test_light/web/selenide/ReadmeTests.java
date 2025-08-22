package io.testomat.test_light.web.selenide;

import org.junit.jupiter.api.Test;

import static io.testomat.test_light.resurses.enums.CompanyNames.QA_CLUB_LVIV;
import static io.testomat.test_light.resurses.enums.ProjectNames.MANUFACTURE_TESTOMATIO;

public class ReadmeTests extends BaseTest {

    @Test
    public void updateReadmeTextInIframe() {
        new ProjectsPage().isLoaded()
                .verifySelectedCompany(QA_CLUB_LVIV)
                .searchProject(MANUFACTURE_TESTOMATIO)
                .selectProject(MANUFACTURE_TESTOMATIO);
        new ProjectPage()
                .isLoaded(MANUFACTURE_TESTOMATIO)
                .openReadme()
                .clickOnEditButton();
        new ReadmePage()
                .isLoaded()
                .clickOnEditReadmeButton()
                .switchToIframe()
                .editReadmeFirstLine(" Test")
                .switchToDefaultContent()
                .clickOnUpdateButton();
    }
}
