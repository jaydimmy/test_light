package io.testomat.test_light.enums;

public enum PageTitles {
    SIGN_IN("Sign In"),
    PROJECTS("Projects"),
    README("Readme");

    public final String title;

    PageTitles(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
