package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AutomationPracticeFormPage extends Checkers {

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
    @FindBy(id = "userNumber")
    private WebElement mobileNumberField;
    @FindBy(xpath = "//*[text()='Sports']/..")
    private WebElement sportsCheckbox;

    public AutomationPracticeFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "automation-practice-form";
    }

    @Step
    public AutomationPracticeFormPage checkUrl() {
        assertUrl("URL соответствует: " + getRelativeUrl());
        return new AutomationPracticeFormPage(webDriver);
    }


    /**
     * CLICKS
     */
    public AutomationPracticeFormPage clickMaleRadioButton() {
        waitAndClick("Нажать на радиобаттон 'Male'", maleRadioButton);
        return new AutomationPracticeFormPage(webDriver);
    }

    public AutomationPracticeFormPage clickSportsCheckbox() {
        if (!sportsCheckbox.isSelected()) {
            waitAndClick("Нажать на чекбокс 'Sports'", sportsCheckbox);
        }else {
            logger.info("Чекбокс 'Sports' был выбран");
        }
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

    @Step
    public AutomationPracticeFormPage enterTextInMobileNumberField(String number) {
        enterText("Ввести значение в поле 'Mobile Number'", mobileNumberField, number);
        return new AutomationPracticeFormPage(webDriver);
    }


}






