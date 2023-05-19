package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends abstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;


    }

    @FindBy(id = "login")
    WebElement loginBtn;
    @FindBy(name = "username")
    WebElement userName;
    @FindBy(name = "password")
    WebElement passwordEle;
    @FindBy(id = "login_action")
    WebElement submit;
    @FindBy(css = ".ta-web-ui-toast__text")
    WebElement errorMessg;


    public void loginApplication(String email, String password) {
        loginBtn.click();
        userName.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
    }
    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessg);
        return errorMessg.getText();
    }

    public void goTo() {
        driver.get("https://www.teachaway.com/");
    }

}
