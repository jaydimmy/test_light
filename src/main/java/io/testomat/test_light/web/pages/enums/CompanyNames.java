package io.testomat.test_light.web.pages.enums;

public enum CompanyNames {
    QA_CLUB_LVIV("QA Club Lviv");

    public final String name;

    CompanyNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
