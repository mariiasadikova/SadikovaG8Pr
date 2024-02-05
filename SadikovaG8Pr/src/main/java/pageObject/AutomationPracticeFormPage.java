package pageObject;

import core.Actions;
import core.Checkers;
import core.Urls;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AutomationPracticeFormPage extends Actions {

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;
    @FindBy(id = "userEmail")
    private WebElement userEmailField;
    @FindBy(xpath = "//input[@name='gender' and @value='Male']/..")
    private WebElement maleRadioButton;
    @FindBy(xpath = "//input[@name='gender' and @value='Female']/..")
    private WebElement femaleRadioButton;
    @FindBy(xpath = "//input[@name='gender' and @value='Other']/..")
    private WebElement otherRadioButton;

    public AutomationPracticeFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * CLICKS
     */
    public AutomationPracticeFormPage clickMaleRadioButton() {
        waitAndClick("Нажать на радиобаттон 'Male'", maleRadioButton);
        return new AutomationPracticeFormPage(webDriver);
    }

    /**
     * ENTER DATA
     */
    @Step
    public AutomationPracticeFormPage enterTextInFirstNameField(String name) {
        enterText("Ввести значение в поле 'First Name'", firstNameField, name);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step
    public AutomationPracticeFormPage enterTextInLastNameField(String lastName) {
        enterText("Ввести значение в поле 'Last Name'", lastNameField, lastName);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step
    public AutomationPracticeFormPage enterTextInUserEmailFieldField(String email) {
        enterText("Ввести значение в поле 'User Email'", userEmailField, email);
        return new AutomationPracticeFormPage(webDriver);
    }



    }






