import core.BaseTest;
import io.qameta.allure.Description;
import org.junit.Test;
import testInfo.UserData;

public class LoginTests extends BaseTest {

    String userName = UserData.USER_LOGIN;

    @Test
    @Description("Авторизовать пользователя")
    public void test004() {
        homePage.openHomePage()
                .clickBookStoreApplicationsCard()
                .clickLoginButton();
        loginPage.checkUrl()
                .enterTextInUserNameField(userName)
                .enterTextInPasswordField(UserData.PASSWORD)
                .clickLoginButton();
        profilePage.checkUrl()
                .checkLogOutButtonIsVisible()
                .checkTextsContainsInUserNameField(userName);

    }
}
