package io.testomat.test_light;

import org.junit.jupiter.api.Test;

import static io.testomat.test_light.Utils.clickProjectSection;
import static io.testomat.test_light.Utils.findProjectSection;
import static io.testomat.test_light.Utils.selectCompany;
import static io.testomat.test_light.Utils.verifyLoaderIsNotVisible;
import static io.testomat.test_light.Utils.verifyMainAppVisible;

public class SectionTests extends BaseTest {
    @Test
    public void sectionTest() {
        selectCompany("QA Club Lviv");
        findProjectSection("Manufacture light");
        clickProjectSection("Manufacture light");
        verifyLoaderIsNotVisible();
        verifyMainAppVisible();
    }
}
