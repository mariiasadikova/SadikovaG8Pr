package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftForm extends Checkers {

    @FindBy(xpath = "//span[text()='Practice Form']/ancestor::li")
    private WebElement practiceFormButton;
    @FindBy(xpath = "//span[text()='Upload and Download']/ancestor::li")
    private WebElement uploadAndDownloadButton;
    @FindBy(xpath = "//span[text()='Login']/ancestor::li")
    private WebElement loginButton;


    public LeftForm(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "";
    }

    @Step("Нажать на кнопку 'Practice Form'")
    public AutomationPracticeFormPage clickPracticeFormButton() {
        waitAndClick(practiceFormButton);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Нажать на кнопку 'Login'")
    public AutomationPracticeFormPage clickLoginButton() {
        scrollToElement(loginButton);
        waitAndClick(loginButton);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Нажать на кнопку 'Upload and Download'")
    public UploadDownloadPage clickUploadAndDownloadButton() {
        scrollToElement(uploadAndDownloadButton);
        waitAndClick(uploadAndDownloadButton);
        return new UploadDownloadPage(webDriver);
    }


}
