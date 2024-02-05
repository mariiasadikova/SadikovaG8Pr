package pageObject;

import core.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftForm extends Actions {

    @FindBy(xpath = "//span[text()='Practice Form']/ancestor::li")
    private WebElement practiceFormButton;


    public LeftForm(WebDriver webDriver) {
        super(webDriver);
    }
}
