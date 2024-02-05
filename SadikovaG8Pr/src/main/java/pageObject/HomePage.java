package pageObject;

import core.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Actions {

    @FindBy(xpath = "//div[contains(@class,'top-card')]//*[text()='Forms']")
    private WebElement formsCard;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage clickFormsCard() {
        waitAndClick("Нажать на карточку 'Forms'", formsCard);
        return new HomePage(webDriver);
    }
}
