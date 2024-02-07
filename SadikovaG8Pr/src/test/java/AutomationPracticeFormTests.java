import core.BaseTest;
import io.qameta.allure.Description;
import org.junit.Test;
import testInfo.UserData;

import static core.Actions.getFileNameFromPath;

public class AutomationPracticeFormTests extends BaseTest {

    String userName = UserData.USER_NAME;
    String lastName = UserData.LAST_NAME;
    String mobileNumber = UserData.MOBILE_NUMBER;
    String email = UserData.randomEmail();
    String path = UserData.PHOTO_OF_USER_PATH;
    String address = UserData.generateRandomString(50);
    String state = UserData.STATE;
    String city = UserData.CITY;
    String imageName = getFileNameFromPath(path);

    @Test
    @Description("Отправить регистрационную форму")
    public void test001() {
        homePage.openHomePage()
                .clickFormsCard()
                .clickPracticeFormButton()
                .checkUrl()
                .enterTextInFirstNameField(userName)
                .enterTextInLastNameField(lastName)
                .enterTextInUserEmailFieldField(email)
                .clickMaleRadioButton()
                .enterTextInMobileNumberField(mobileNumber)
                .clickSportsCheckbox()
                .uploadFile(path)
                .enterTextInCurrentAddressField(address)
                .clickStateField()
                .clickStateDropdownField(state)
                .clickCityField()
                .clickCityDropdownField(city)
                .clickSubmitButton()
                .checkTextsContainsInSubmitFormPopup(userName, lastName, email, mobileNumber, address, state, city, imageName)
                .checkUrl();

    }

    @Test
    @Description("Отправить регистрационную форму c пустыми полями")
    public void test002() throws InterruptedException {
        homePage.openHomePage()
                .clickFormsCard()
                .clickPracticeFormButton()
                .checkUrl()
                .clickSubmitButton()
                .checkMainFieldsHasRedBoarderColor()
                .checkUrl();

    }

}
