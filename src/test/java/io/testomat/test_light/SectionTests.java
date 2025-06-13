package io.testomat.test_light;

import io.testomat.test_light.web.pages.ProjectPage;
import io.testomat.test_light.web.pages.ProjectsPage;
import org.junit.jupiter.api.Test;

import static io.testomat.test_light.web.pages.ProjectsPage.MANUFACTURE_LIGHT;
import static io.testomat.test_light.web.pages.ProjectsPage.QA_CLUB_LVIV;


public class SectionTests extends BaseTest {

    @Test
    public void findSectionByNameAndOpenTest() {
        new ProjectsPage()
                .isLoaded()
                .verifySelectedCompany(QA_CLUB_LVIV)
                .searchProject(MANUFACTURE_LIGHT)
                .selectProject(MANUFACTURE_LIGHT);
        new ProjectPage()
                .isLoaded(MANUFACTURE_LIGHT);
    }
}
