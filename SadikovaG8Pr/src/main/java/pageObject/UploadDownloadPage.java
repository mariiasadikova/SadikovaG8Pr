package pageObject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadPage extends Checkers {

    static String downloadPath = getAbsolutePath("downloads");
    @FindBy(id = "downloadButton")
    private WebElement downloadButton;

    public UploadDownloadPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "upload-download";
    }

    @Step("Нажать на кнопку 'Download'")
    public UploadDownloadPage clickDownloadButton() {
        waitAndClick(downloadButton);
        return new UploadDownloadPage(webDriver);
    }

    @Step("Получить имя файла")
    public String getImageName() {
        String nameImage = downloadButton.getAttribute("download");
        logger.info("Имя файла " + nameImage);
        return nameImage;
    }

    @Step("Проверить что файл загрузился в папку")
    public UploadDownloadPage checkImageIsDownloaded(String nameImage) {
        File dir = new File(downloadPath);
        if (dir.exists() && dir.isDirectory()) {
            logger.info("Директория существует. Список файлов:");
            for (File file : dir.listFiles()) {
                logger.info(file.getName());
            }
        } else {
            logger.info("Директория не найдена.");
        }
        Assert.assertTrue(isFileDownloaded(downloadPath, nameImage));

        return new UploadDownloadPage(webDriver);
    }

    @Step("Удалить загруженный файл")
    public UploadDownloadPage deleteDownloadFile(String imageName) {
        deleteImage(downloadPath + imageName);
        return new UploadDownloadPage(webDriver);
    }


}
