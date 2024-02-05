package pageObject;

import core.Actions;
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
    @FindBy(xpath = "//input[@name='gender' and @value='Male']")
    private WebElement maleRadioButton;
    @FindBy(xpath = "//input[@name='gender' and @value='Female']")
    private WebElement femaleRadioButton;
    @FindBy(xpath = "//input[@name='gender' and @value='Other']")
    private WebElement otherRadioButton;


    public AutomationPracticeFormPage(WebDriver webDriver) {
        super(webDriver);
    }


}
