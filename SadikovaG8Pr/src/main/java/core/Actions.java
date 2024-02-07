package core;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

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


    @Step
    protected void enterText(WebElement element, String text) {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted into input" + getElementName(element));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    @Step
    public void goToWebPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened: " + url);
        } catch (Exception e) {
            logger.error("Can not open page: " + url);
            Assert.fail("Can not open page");
        }
    }

    //--------------------------------upload---------------------------
    public static String getAbsolutePath(String file) {
        Path patch = Paths.get("").toAbsolutePath().resolve(file);
        String absolutePath = patch.toString();
        return absolutePath;
    }

    public void uploadImage(WebElement element, String path) {
        String absolutePath = getAbsolutePath(path);
        element.sendKeys(absolutePath);

    }

    //-------------------------elements-------------------------------
    public void waitClickability(WebElement element) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.info("Элемент не кликабельный " + getElementName(element) + "Error: " + e.getMessage());
        }
    }


    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step
    public void waitAndClick(WebElement element) {
        try {
            waitClickability(element);

            element.click();
            logger.info("Шаг выполнен: клик по элементу " + getElementName(element) + " прошел успешно.");
        } catch (Exception e) {
            logger.error("Ошибка при клике по элементу " + getElementName(element) + ": " + e.getMessage(), e);
        }
    }

    public static String getFileNameFromPath(String fullPath) {
        String[] parts = fullPath.split("/");
        return parts[parts.length - 1];
    }

    public static String rgbToHex(String rgb) {
        String[] numbers = rgb.replace("rgba(", "").replace("rgb(", "").replace(")", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());

        return String.format("#%02x%02x%02x", r, g, b);
    }

    public void deleteImage(String downloadPath) {
        try {
            Path path = Paths.get(downloadPath);
            logger.info(downloadPath);
            Files.deleteIfExists(path);
            logger.info("Файл успешно удален");
        } catch (Exception e) {
            logger.info("Произошла ошибка при удалении файла: " + e.getMessage());
        }
    }
}