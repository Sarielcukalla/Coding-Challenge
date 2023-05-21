package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ProfilePage extends abstractComponent {
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    @FindBy(css = "button[id='documents-placeholder-cta'] div[class='ta-web-ui-button__text']")
    WebElement uploadDocumentsBtn;
    @FindBy(xpath = "(//input[@id='checkbox'])[1]")
    WebElement checkBoxDocuments;
    @FindBy(xpath = "(//span[@class='ta-web-ui-file__button-text'])[1]")
    WebElement addDocuments;
    @FindBy(css = ".fsp-select-labels")
    WebElement selectFile;
    @FindBy(css = "span[title='Upload']")
    WebElement uploadFile;


    public void addDocumentsCv() throws IOException, InterruptedException {
        uploadDocumentsBtn.click();
        checkBoxDocuments.click();
        addDocuments.click();
        waitForWebElementToAppear(selectFile);
        selectFile.click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\User\\Desktop\\coding challenge\\Coding-Challenge\\fileUploadTech.exe");
        waitForWebElementToAppear(uploadFile);
        uploadFile.click();


    }
}
