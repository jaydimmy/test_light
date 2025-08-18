package io.testomat.test_light.playwright.web.common;

import com.microsoft.playwright.junit.Options.Trace;
import com.microsoft.playwright.junit.OptionsFactory;

import static io.testomat.test_light.helpers.EnvHelper.getEnvValue;

public class Options implements OptionsFactory {
    public static final String baseUrl = getEnvValue("BASE_URL");

    @Override
    public com.microsoft.playwright.junit.Options getOptions() {
        return new com.microsoft.playwright.junit.Options()
                .setHeadless(false)
                .setBaseUrl(baseUrl)
                .setTrace(Trace.ON);
    }
}
