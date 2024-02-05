import core.BaseTest;
import core.Urls;
import io.qameta.allure.Description;
import org.junit.Test;
import testInfo.UserData;

public class AutomationPracticeFormTests extends BaseTest {

    @Test
    @Description("Отправить регистрационную форму")
    public void test001() {
        homePage.clickFormsCard()
                .clickPracticeFormButton()
                .enterTextInFirstNameField(UserData.USER_NAME)
                .enterTextInLastNameField(UserData.LAST_NAME)
                .enterTextInUserEmailFieldField(UserData.randomEmail())
                .clickMaleRadioButton();
        checkers.assertUrl(Urls.PRACTICE_FORM_PAGE);


    }
}
