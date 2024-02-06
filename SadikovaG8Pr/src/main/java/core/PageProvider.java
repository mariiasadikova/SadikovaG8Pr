package core;

import org.openqa.selenium.WebDriver;
import pageObject.AutomationPracticeFormPage;
import pageObject.HomePage;
import pageObject.LeftForm;

public class PageProvider {
    protected Actions actions;


    protected pageObject.HomePage homePage;
    protected AutomationPracticeFormPage automationPracticeFormPage;
    protected pageObject.LeftForm leftForm;


    protected void init(WebDriver webDriver) {
        actions = new Actions(webDriver);
        homePage = new HomePage(webDriver);
        automationPracticeFormPage = new AutomationPracticeFormPage(webDriver);
        leftForm = new LeftForm(webDriver);

    }
}
