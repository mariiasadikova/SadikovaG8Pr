package core;

import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PageProvider {
    protected Actions actions;


    protected pageObject.HomePage homePage;
    protected AutomationPracticeFormPage automationPracticeFormPage;
    protected pageObject.LeftForm leftForm;
    protected pageObject.UploadDownloadPage uploadDownloadPage;
    protected pageObject.LoginPage loginPage;
    protected pageObject.ProfilePage profilePage;


    protected void init(WebDriver webDriver) {
        actions = new Actions(webDriver);
        homePage = new HomePage(webDriver);
        automationPracticeFormPage = new AutomationPracticeFormPage(webDriver);
        leftForm = new LeftForm(webDriver);
        uploadDownloadPage = new UploadDownloadPage(webDriver);
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);

    }
}
