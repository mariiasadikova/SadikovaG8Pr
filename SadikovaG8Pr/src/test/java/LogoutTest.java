import core.BaseTest;
import io.qameta.allure.Description;
import org.junit.Test;
import testInfo.UserData;

public class LogoutTest extends BaseTest {

    @Test
    @Description("Пользователь разлогинивается")
    public void test005() {
        loginPage.loginToProfile(UserData.USER_LOGIN, UserData.PASSWORD);
        profilePage.checkLogOutButtonIsVisible()
                .checkTextsContainsInUserNameField(UserData.USER_LOGIN)
                .clickLogOutButton();
        loginPage.checkUrl()
                .checkUserNameButtonIsVisible()
                .checkPasswordButtonIsVisible();


    }
}
