package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeflPage extends abstractComponent {
    WebDriver driver;

    public TeflPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='btn btn-cta-front']")
    WebElement regBtn;
    @FindBy(name = "firstname")
    WebElement nameReg;
    @FindBy(name = "lastname")
    WebElement lastNameReg;
    @FindBy(xpath = "//input[@autocomplete='email']")
    WebElement emailReg;
    @FindBy(css = "input[value='REGISTER']")
    WebElement submitReg;


    public void registerTefl(String name, String lastName, String email) {
        regBtn.click();
        nameReg.sendKeys(name);
        lastNameReg.sendKeys(lastName);
        emailReg.sendKeys(email);
    }

    public  ConfirmationPage submitRegistration(){
        submitReg.click();
        return new ConfirmationPage(driver);
    }


}
