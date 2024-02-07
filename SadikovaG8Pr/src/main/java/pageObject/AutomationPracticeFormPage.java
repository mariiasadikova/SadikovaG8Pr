package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AutomationPracticeFormPage extends Checkers {

    String stateAndCityDropdownField = "//div[contains(text(),'%s')]";
    String errorColor = "#dc3545";

    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
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
    @FindBy(xpath = "//*[text()='Sports']/ancestor::div[contains(@class,'custom-checkbox')]")
    private WebElement sportsCheckbox;
    @FindBy(id = "uploadPicture")
    private WebElement uploadFileField;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;
    @FindBy(id = "state")
    private WebElement stateField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(xpath = "//div[contains(@class,'show') and contains(@class,'modal') and @style='display: block;']/div")
    private WebElement submitFormPopup;
    @FindBy(xpath = "//form[@class='was-validated']")
    private WebElement validationErrorForm;


    public AutomationPracticeFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "automation-practice-form";
    }


    @Step("URL соответствует странице 'Automation Practice Form': ")
    public AutomationPracticeFormPage checkUrl() {
        assertUrl();
        return new AutomationPracticeFormPage(webDriver);
    }


    /**
     * CLICKS
     */
    @Step("Нажать на радиобаттон 'Male'")
    public AutomationPracticeFormPage clickMaleRadioButton() {
        waitAndClick(maleRadioButton);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Нажать на кнопку 'Submit'")
    public AutomationPracticeFormPage clickSubmitButton() {
        waitAndClick(submitButton);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Нажать на поле 'State'")
    public AutomationPracticeFormPage clickStateField() {
        scrollToElement(stateField);
        waitAndClick(stateField);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Нажать на значение из 'State' дропдаун меню")
    public AutomationPracticeFormPage clickStateDropdownField(String state) {
        waitAndClick(webDriver.findElement(By.xpath(String.format(stateAndCityDropdownField, state))));
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Нажать на значение из 'City' дропдаун меню")
    public AutomationPracticeFormPage clickCityDropdownField(String state) {
        waitAndClick(webDriver.findElement(By.xpath(String.format(stateAndCityDropdownField, state))));
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Нажать на поле 'City'")
    public AutomationPracticeFormPage clickCityField() {
        scrollToElement(cityField);
        waitAndClick(cityField);
        return new AutomationPracticeFormPage(webDriver);
    }


    @Step("Нажать на чекбокс 'Sports'")
    public AutomationPracticeFormPage clickSportsCheckbox() {
        scrollToElement(sportsCheckbox);
        if (!sportsCheckbox.isSelected()) {
            waitAndClick(sportsCheckbox);
        } else {
            logger.info("Чекбокс 'Sports' был выбран");
        }
        return new AutomationPracticeFormPage(webDriver);
    }

    /**
     * UPLOAD
     */
    @Step("Загрузить фото пользователя")
    public AutomationPracticeFormPage uploadFile(String path) {
        uploadImage(uploadFileField, path);
        return new AutomationPracticeFormPage(webDriver);
    }

    /**
     * ENTER DATA
     */
    @Step("Ввести значение в поле 'First Name'")
    public AutomationPracticeFormPage enterTextInFirstNameField(String name) {
        enterText(firstNameField, name);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Ввести значение в поле 'Last Name'")
    public AutomationPracticeFormPage enterTextInLastNameField(String lastName) {
        enterText(lastNameField, lastName);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Ввести значение в поле 'User Email'")
    public AutomationPracticeFormPage enterTextInUserEmailFieldField(String email) {
        enterText(userEmailField, email);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Ввести значение в поле 'Mobile Number'")
    public AutomationPracticeFormPage enterTextInMobileNumberField(String number) {
        enterText(mobileNumberField, number);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Ввести значение в поле 'Current address'")
    public AutomationPracticeFormPage enterTextInCurrentAddressField(String address) {
        scrollToElement(currentAddressField);
        enterText(currentAddressField, address);
        return new AutomationPracticeFormPage(webDriver);
    }

    /**
     * CHECKERS
     */
    @Step("Отображены данные о пользователе в попап 'Submit Form'")
    public AutomationPracticeFormPage checkTextsContainsInSubmitFormPopup(String... texts) {
        checkTextFromElement(submitFormPopup, texts);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Отображена форма с ошибками валидации")
    public AutomationPracticeFormPage checkValidationErrorFormIsVisible() {
        checkIsElementVisible(validationErrorForm);
        return new AutomationPracticeFormPage(webDriver);
    }

    @Step("Обязательные поля содержат красный css border-color: #dc3545")
    public AutomationPracticeFormPage checkMainFieldsHasRedBoarderColor() throws InterruptedException {
        checkValidationErrorFormIsVisible();
        Thread.sleep(2500);
        checkCssValue("border-color", errorColor, firstNameField, lastNameField, mobileNumberField);
        return new AutomationPracticeFormPage(webDriver);
    }




}






