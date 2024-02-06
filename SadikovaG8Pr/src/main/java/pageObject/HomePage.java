package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Checkers {

    @FindBy(xpath = "//*[text()='Forms']/ancestor::div[contains(@class,'top-card')]")
    private WebElement formsCard;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return baseUrl;
    }

    @Step
    public LeftForm clickFormsCard() {
        waitAndClick("Нажать на карточку 'Forms'", formsCard);
        return new LeftForm(webDriver);
    }

    @Step
    public HomePage openHomePage() {
       goToWebPage("Перейти на страницу 'Home Page'", getRelativeUrl());
        return new HomePage(webDriver);
    }

    public void assertUrl() {
    }


}
