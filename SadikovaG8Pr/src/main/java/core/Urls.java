package core;

import org.openqa.selenium.WebDriver;

public class Urls extends Actions {

    static final String baseUrl = "https://demoqa.com/";

    public static String FORM_PAGE = baseUrl +  "forms",
    PRACTICE_FORM_PAGE = baseUrl + "automation-practice-form";


    public Urls(WebDriver webDriver) {
        super(webDriver);
    }
}
