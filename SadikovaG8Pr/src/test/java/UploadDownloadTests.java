import core.BaseTest;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Test;

public class UploadDownloadTests extends BaseTest {
    String imageName;

    @Test
    @Description("Скачать файл и проверить его наличие в папке")
    public void test003() {
        homePage.openHomePage()
                .clickElementsCard();
        leftForm.clickUploadAndDownloadButton();
        uploadDownloadPage.clickDownloadButton();
        imageName = uploadDownloadPage.getImageName();
        uploadDownloadPage.checkImageIsDownloaded(imageName);

    }

    @After
    public void afterTest003() {
        uploadDownloadPage.deleteDownloadFile("\\" + imageName);
    }
}
