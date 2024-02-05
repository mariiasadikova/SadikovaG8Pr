import core.BaseTest;
import core.Urls;
import io.qameta.allure.Description;
import org.junit.Test;

public class AutomationPracticeFormTests extends BaseTest {

    @Test
    @Description("Отправить регистрационную форму")
    public void test001(){
    homePage.clickFormsCard();
    }
}
