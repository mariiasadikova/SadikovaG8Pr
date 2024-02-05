package core;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkers extends Actions {
    //-------------------------------------Проверка по url ----------------------

    @Step("URL соответствует")
    public void assertUrl(String url) {
        logger.info("Current Url " + webDriver.getCurrentUrl());
        webDriverWait10.until(ExpectedConditions.urlToBe(url));
        logger.info("Url is correct");
    }

    @Step("URL содержит")
    public void containsUrl(String url) {
        webDriverWait10.until(ExpectedConditions.urlContains(url));
        logger.info("Url is correct");
    }

    @Step("URL содержит паттерн")
    public void checkUrlWithPatternUrl(String url) {
        Assert.assertTrue("Invalid page \n"
                        + "Expected result: " + url + "\n"
                        + "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(url));
    }

    public Checkers(WebDriver driver) {
        super(driver);
    }
}
