package io.testomat.test_light.selenium.web.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

    private static final ThreadLocal<WebDriver> driverThreadLocal = ThreadLocal.withInitial(ChromeDriver::new);

    public static WebDriver driver() {
        return driverThreadLocal.get();
    }

    public static void qitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}