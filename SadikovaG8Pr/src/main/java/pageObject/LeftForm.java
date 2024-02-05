package pageObject;

import core.Actions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftForm extends Actions {

    @FindBy(xpath = "//span[text()='Practice Form']/ancestor::li")
    private WebElement practiceFormButton;

    public LeftForm(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public AutomationPracticeFormPage clickPracticeFormButton() {
        waitAndClick("Нажать на кнопку 'Practice Form'", practiceFormButton);
        return new AutomationPracticeFormPage(webDriver);
    }
}
