package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class BaseTest extends PageProvider {

    @FindBy(xpath = "//div[@class='fc-dialog-container']//button[contains(@class,'fc-primary-button') and not(contains(@class,'fc-confirm-choices'))]//p")
    private WebElement acceptTerms;
    @FindBy(xpath = "//div[@class='fc-consent-root']")
    private WebElement iframe;

    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private void driverInit() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1); // Разрешить уведомления
        prefs.put("profile.default_content_setting_values.geolocation", 1); // Разрешить геолокацию
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-popup-blocking");
      //  options.addArguments("--headless");
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

    //Will be executed before each test
    @Before
    public void setUp() {
        logger.info("--------" + testName.getMethodName() + " was started-----------");
        webDriver = initDriver();
        webDriver.manage().window().maximize(); // maximize window
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // wait 5 seconds
        logger.info("Browser was opened");
        init(webDriver);
        webDriver.get(Urls.baseUrl);
//        actions.switchToFrame("", iframe);
        actions.waitAndClick("",acceptTerms);
        if (webDriver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) webDriver).executeScript("document.querySelector('//div[@class='fc-dialog-container']//button[contains(@class,'fc-primary-button') and not(contains(@class,'fc-confirm-choices'))]//p').click();");
        }

    }

    @After
    public void tearDown() {
        saveScreenshotPNG(webDriver);
        //  webDriver.quit();
        logger.info("Browser was closed");
        logger.info("----------" + testName.getMethodName() + " was ended");
    }

    @Rule
    public TestName testName = new TestName();
}


