package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testInfo.UserData;

public class LoginPage extends Checkers {

    @FindBy(id = "userName")
    private WebElement userNameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login")
    private WebElement loginButton;


    @Override
    protected String getRelativeUrl() {
        return "login";
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("URL соответствует странице 'Login': ")
    public LoginPage checkUrl() {
        assertUrl();
        return new LoginPage(webDriver);
    }

    @Step("Перейти на страницу 'Login': ")
    public LoginPage goToLoginProfile() {
        goToWebPage(baseUrl + getRelativeUrl());
        return new LoginPage(webDriver);
    }

    @Step("Нажать на кнопку 'Login'")
    public LoginPage clickLoginButton() {
        waitAndClick(loginButton);
        return new LoginPage(webDriver);
    }

    @Step("Заполнить поле 'User Name'")
    public LoginPage enterTextInUserNameField(String userName) {
        enterText(userNameField, userName);
        return new LoginPage(webDriver);
    }

    @Step("Заполнить поле 'Password'")
    public LoginPage enterTextInPasswordField(String password) {
        enterText(passwordField, password);
        return new LoginPage(webDriver);
    }

    public LoginPage loginToProfile(String username, String password) {
        goToLoginProfile()
                .enterTextInUserNameField(username)
                .enterTextInPasswordField(UserData.PASSWORD)
                .clickLoginButton();
        return new LoginPage(webDriver);
    }

    @Step("Отображена кнопка 'User Name'")
    public LoginPage checkUserNameButtonIsVisible() {
        checkIsElementVisible(userNameField);
        return new LoginPage(webDriver);
    }

    @Step("Отображена кнопка 'Password'")
    public LoginPage checkPasswordButtonIsVisible() {
        checkIsElementVisible(passwordField);
        return new LoginPage(webDriver);
    }




}
