package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftForm extends Checkers {

    @FindBy(xpath = "//span[text()='Practice Form']/ancestor::li")
    private WebElement practiceFormButton;

    public LeftForm(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "";
    }

    @Step
    public AutomationPracticeFormPage clickPracticeFormButton() {
        waitAndClick("Нажать на кнопку 'Practice Form'", practiceFormButton);
        return new AutomationPracticeFormPage(webDriver);
    }
}
