package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class BaseTest extends PageProvider {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private void driverInit() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1); // Разрешить уведомления
        prefs.put("profile.default_content_setting_values.geolocation", 1); // Разрешить геолокацию
        prefs.put("download.default_directory", new File("downloads").getAbsolutePath()); // Использование абсолютного пути
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--window-size=1920,1080");
        webDriver = new ChromeDriver(options);
    }

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equals(browser.toLowerCase()))) { // default browser -Dbrowser=chrome
            WebDriverManager.chromedriver().setup();
            driverInit();
        } else if ("firefox".equals(browser.toLowerCase())) { // -Dbrowser=firefox
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("safari".equalsIgnoreCase(browser)) {
            WebDriverManager.safaridriver().setup();
            webDriver = new SafariDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser " + browser + " is not supported");
        }
        return webDriver;
    }


    @Before
    public void setUp() {
        logger.info("--------" + testName.getMethodName() + " was started-----------");
        // webDriver = initDriver();
        driverInit();
        webDriver.manage().window().maximize(); // maximize window
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Browser was opened");
        init(webDriver);



    }

    @After
    public void tearDown() {
        saveScreenshotPNG(webDriver);
    //    webDriver.quit();
        logger.info("Browser was closed");
        logger.info("----------" + testName.getMethodName() + " was ended");
    }

    @Rule
    public TestName testName = new TestName();
}


