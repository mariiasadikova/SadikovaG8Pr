package pageObject;

import core.Actions;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


abstract public class Checkers extends Actions {
    final String baseUrl = "https://demoqa.com/";

    // Конструктор
    public Checkers(WebDriver webDriver) {
        super(webDriver);
    }

    abstract protected String getRelativeUrl();

    protected void assertUrl(String step) {
        Assert.assertEquals("Invalid url " + webDriver.getCurrentUrl(), baseUrl + getRelativeUrl(), webDriver.getCurrentUrl());
        logger.info("Url is correct");
    }

    protected void containsUrl(String step) {
        webDriverWait10.until(ExpectedConditions.urlContains(baseUrl + getRelativeUrl()));
        logger.info("Url is correct");
    }

    protected void checkUrlWithPatternUrl(String step) {
        Assert.assertTrue("Invalid page \n"
                        + "Expected result: " + baseUrl + getRelativeUrl() + "\n"
                        + "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl()));
    }

}
