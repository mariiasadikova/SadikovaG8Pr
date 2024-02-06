import core.BaseTest;
import io.qameta.allure.Description;
import org.junit.Test;
import testInfo.UserData;

public class AutomationPracticeFormTests extends BaseTest {

    @Test
    @Description("Отправить регистрационную форму")
    public void test001() {
        homePage.openHomePage()
                .clickFormsCard()
                .clickPracticeFormButton()
                .checkUrl()
                .enterTextInFirstNameField(UserData.USER_NAME)
                .enterTextInLastNameField(UserData.LAST_NAME)
                .enterTextInUserEmailFieldField(UserData.randomEmail())
                .clickMaleRadioButton()
                .enterTextInMobileNumberField(UserData.MOBILE_NUMBER)
                .clickSportsCheckbox();




    }
}
