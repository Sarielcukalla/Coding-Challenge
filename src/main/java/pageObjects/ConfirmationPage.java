package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends abstractComponent {

WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }
    @FindBy(xpath = "//p[text()='Thank you! Your registration is confirmed.']")
    WebElement confirmationMessage;

    public String GetConfMess() {

        return confirmationMessage.getText();
    }
}
