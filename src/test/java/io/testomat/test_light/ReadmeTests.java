package io.testomat.test_light;

import io.testomat.test_light.web.pages.ProjectPage;
import io.testomat.test_light.web.pages.ProjectsPage;
import io.testomat.test_light.web.pages.ReadmePage;
import org.junit.jupiter.api.Test;

import static io.testomat.test_light.web.pages.ProjectsPage.MANUFACTURE_TESTOMATIO;
import static io.testomat.test_light.web.pages.ProjectsPage.QA_CLUB_LVIV;

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
