package io.testomat.test_light.selenium;

import io.testomat.test_light.selenium.common.Login;
import io.testomat.test_light.selenium.common.WebDriverLifeCycleExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.test_light.enums.ProjectNames.MANUFACTURE_LIGHT;
import static io.testomat.test_light.selenium.web.common.Elements.find;

@ExtendWith({WebDriverLifeCycleExtension.class, Login.class})
public class ProjectsTests {

    @Test
    public void findProjectAndOpenTest() {
        String projectName = MANUFACTURE_LIGHT.getName();
        find(".common-flash-success").waitFor().visibility();
        find(".common-page-header-right #search").sendKeys(projectName);
        find("a[title='manufacture light']").click();
        find(".sticky-header h2").waitFor().hasText(projectName);
    }
}
