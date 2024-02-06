package core;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Actions {

    protected WebDriver webDriver;

    protected Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait10, webDriverWait15, webDriverWait3;

    public Actions(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        webDriverWait3 = new WebDriverWait(webDriver, Duration.ofSeconds(3));

    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }


    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    public void waitClickability(WebElement element) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.info("Элемент не кликабельный " + getElementName(element) + "Error: " + e.getMessage());
        }
    }

    @Step
    public void waitAndClick(String step, WebElement element) {
        try {
            waitClickability(element);

            element.click();
            logger.info("Шаг '" + step + "' выполнен: клик по элементу " + getElementName(element) + " прошел успешно.");
        } catch (Exception e) {
            logger.error("Ошибка при клике по элементу " + getElementName(element) + ": " + e.getMessage(), e);
        }
    }

    @Step
    protected void enterText(String step, WebElement element, String text) {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into input" + getElementName(element));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void goToWebPage(String step, String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened: " + url);
        } catch (Exception e) {
            logger.error("Can not open page: " + url);
            Assert.fail("Can not open page");
        }
    }

    @Step("{step}")
    public void switchToFrame(String step, WebElement iframe) {
        waitClickability(iframe);
        webDriver.switchTo().frame(iframe);

    }


    //------------исправить



    public void switchTab(int tab) {
        try {
            ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(tab));
            logger.info("Tab is switch and opened: " + tab);
        } catch (Exception e) {
            webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
            logger.info("Was used hot keys " + tab);

        }
    }

    public void openWindow() throws InterruptedException {
        ((JavascriptExecutor) webDriver).executeScript("window.open();");
        logger.info("New window is open");
    }

    public void closeTab(int tabNumber) {
        try {
            ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(tabNumber));
            webDriver.close();
            logger.info("Page is closed");
        } catch (Exception e) {
            webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
            logger.info("Was used hot key. Page is closed");
        }
    }

    public void refreshPage() {
        webDriver.navigate().refresh();
        logger.info("Page is refreshed");
    }
}