package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends abstractComponent {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;


    }

    @FindBy(xpath = "(//img[@alt='Teach Away logo'])[1]")
    WebElement logoBtn;
    @FindBy(css = ".ub-emb-close")
    WebElement btnClose;
    @FindBy(id = "hs-eu-confirmation-button")
    WebElement alertConf;

    By userProfile = By.cssSelector(".user-menu");

    public void goToHomePage() {
        waitForElementToAppear(userProfile);
        logoBtn.click();
        waitForWebElementToAppear(btnClose);
        btnClose.click();
        waitForWebElementToAppear(alertConf);
        alertConf.click();
    }

}
