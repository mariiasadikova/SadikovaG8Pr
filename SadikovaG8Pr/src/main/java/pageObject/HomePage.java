package pageObject;

import core.Actions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Actions {

    @FindBy(xpath = "//*[text()='Forms']/ancestor::div[contains(@class,'top-card')]")
    private WebElement formsCard;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public LeftForm clickFormsCard() {
        waitAndClick("Нажать на карточку 'Forms'", formsCard);
        return new LeftForm(webDriver);
    }

    public void assertUrl(){
    }


}
