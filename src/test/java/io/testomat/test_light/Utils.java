package io.testomat.test_light;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);
    private static String initialPageUrl;

    public static SelenideElement findVisibleElementByChainedId(String parentElementId, String elementId) {
        return $(new ByChained(By.id(parentElementId), By.id(elementId))).shouldBe(visible);
    }

    public static String getInitialPageUrl() {
        initialPageUrl = WebDriverRunner.url();
        return initialPageUrl;
    }

    public static void verifyUrlChange() {
        String newUrl = WebDriverRunner.url();
        Wait<WebDriver> wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(2));
        wait.until(d -> {
            if (!initialPageUrl.equals(newUrl)) {
                logger.info("URL has changed to: {}", WebDriverRunner.url());
            }
            return true;
        });
    }

    public static void verifyLoaderIsNotVisible() {
        logger.info("Verifying that the loader is not visible");
        $(By.id("loader")).shouldNotBe(visible);
    }

    public static void selectCompany(String companyName) {
        if (!getCompanyOption(companyName).isSelected()) {
            openCompanyDropdown();
            getCompanyOption(companyName).shouldBe(visible).click();
        }
        logger.info("Project selected: {}", companyName);
    }

    private static SelenideElement getCompanyOption(String companyName) {
        return $$("#company_id option")
                .filter(text(companyName))
                .first()
                .should(exist);
    }

    private static void openCompanyDropdown() {
        $(".common-page-header-left #company_id")
                .shouldBe(visible)
                .click();
    }

    public static void findProjectSection(String sectionName) {
        getSearchInput().setValue(sectionName);
        getSearchInput().shouldHave(value(sectionName));
    }

    public static SelenideElement getSearchInput() {
        return $(".common-page-header-right #search")
                .shouldBe(visible);
    }

    public static void clickProjectSection(String sectionName) {
        $("a[title='" + sectionName + "']")
                .shouldBe(visible)
                .click();
    }

    public static void verifyMainAppVisible() {
        logger.info("Verifying that the main-app is visible");
        $(".main-app")
                .shouldBe(visible)
                .shouldNotBe(empty);
    }
}


