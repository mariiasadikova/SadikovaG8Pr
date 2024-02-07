package pageObject;

import core.Actions;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

import static org.junit.Assert.fail;


abstract public class Checkers extends Actions {
    final String baseUrl = "https://demoqa.com/";

    // Конструктор
    public Checkers(WebDriver webDriver) {
        super(webDriver);
    }

    abstract protected String getRelativeUrl();

    @Step
    protected void assertUrl() {
        Assert.assertEquals("Invalid url " + webDriver.getCurrentUrl(), baseUrl + getRelativeUrl(), webDriver.getCurrentUrl());
        logger.info("Url is correct");
    }

    @Step
    protected void containsUrl() {
        webDriverWait10.until(ExpectedConditions.urlContains(baseUrl + getRelativeUrl()));
        logger.info("Url is correct");
    }

    @Step
    protected void checkUrlWithPatternUrl() {
        Assert.assertTrue("Invalid page \n"
                        + "Expected result: " + baseUrl + getRelativeUrl() + "\n"
                        + "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl()));
    }

    @Step
    protected void checkTextFromElement(WebElement element, String... texts) {
        for (String text : texts) {
            webDriverWait10.until(ExpectedConditions.textToBePresentInElement(element, text));
        }

    }

    @Step
    protected void checkCssValue(String propertyName, String expectedValue, WebElement... elements) {
        try {
            for (WebElement element : elements) {
                String propertyValue = element.getCssValue(propertyName);
                String actualColorHex = rgbToHex(propertyValue);
                logger.info("Actual color hex: " + actualColorHex);
                Assert.assertEquals(expectedValue, actualColorHex);
                logger.info("Expected Value " + expectedValue + " equals " + actualColorHex);
            }
        } catch (Exception e) {
            fail("Error " + e.getMessage());
        }
    }

        public boolean isFileDownloaded(String downloadPath, String fileName) {
            File folder = new File(downloadPath);
            File[] listOfFiles = folder.listFiles();
            boolean found = false;

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.getName().equals(fileName)) {
                        found = true;
                        break;
                    }
                }
            }
            return found;
        }




        @Step
    protected void checkIsElementVisible(WebElement... elements) {
        for (WebElement element : elements) {
            webDriverWait15.until(ExpectedConditions.visibilityOf(element));
            logger.info("Element is displayed " + element.toString());
        }
    }
}
