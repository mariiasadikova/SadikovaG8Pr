package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.security.auth.x500.X500Principal;

public class ProfilePage extends Checkers {

    @FindBy(id = "userName-value")
    private WebElement userNameField;
    @FindBy(xpath = "//button[text()='Log out']")
    private WebElement logOutButton;


    @Override
    protected String getRelativeUrl() {
        return "profile";
    }

    @Step("URL соответствует странице 'Profile': ")
    public ProfilePage checkUrl() {
        assertUrl();
        return new ProfilePage(webDriver);
    }

    @Step("Нажать на кнопку 'Log Out'")
    public ProfilePage clickLogOutButton() {
        waitAndClick(logOutButton);
        return new ProfilePage(webDriver);
    }

    @Step("Отображена кнопка 'LogOut'")
    public ProfilePage checkLogOutButtonIsVisible() {
        checkIsElementVisible(logOutButton);
        return new ProfilePage(webDriver);
    }

    @Step("Отображены данные о пользователе в поле 'User Name'")
    public ProfilePage checkTextsContainsInUserNameField(String... texts) {
        checkTextFromElement(userNameField, texts);
        return new ProfilePage(webDriver);
    }

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }
}
