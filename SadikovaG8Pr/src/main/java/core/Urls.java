package core;

import core.Actions;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Urls extends Actions {

    static final String baseUrl = "https://demoqa.com/";

    public static String FORM_PAGE = baseUrl +  "forms",
    PRACTICE_FORM_PAGE = baseUrl + "automation-practice-form";



    public Urls(WebDriver webDriver) {
        super(webDriver);
    }
}
