package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Checkers {

    @FindBy(xpath = "//*[text()='Forms']/ancestor::div[contains(@class,'top-card')]")
    private WebElement formsCard;
    @FindBy(xpath = "//*[text()='Elements']/ancestor::div[contains(@class,'top-card')]")
    private WebElement elementsCard;
    @FindBy(xpath = "//*[text()='Book Store Application']/ancestor::div[contains(@class,'top-card')]")
    private WebElement bookStoreApplicationsCard;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return baseUrl;
    }

    @Step("Перейти на страницу 'Home Page'")
    public HomePage openHomePage() {
        goToWebPage(getRelativeUrl());
        return new HomePage(webDriver);
    }

    @Step("URL соответствует странице 'Home Page': ")
    public HomePage checkUrl() {
        assertUrl();
        return new HomePage(webDriver);
    }

    @Step("Нажать на карточку 'Forms'")
    public LeftForm clickFormsCard() {
        waitAndClick(formsCard);
        return new LeftForm(webDriver);
    }

    @Step("Нажать на карточку 'Elements'")
    public UploadDownloadPage clickElementsCard() {
        waitAndClick(elementsCard);
        return new UploadDownloadPage(webDriver);
    }

    @Step("Нажать на карточку 'Book Store Application'")
    public LeftForm clickBookStoreApplicationsCard() {
        waitAndClick(bookStoreApplicationsCard);
        return new LeftForm(webDriver);
    }


}
