package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JobsBoard extends abstractComponent {
    WebDriver driver;

    public JobsBoard(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    @FindBy(id = "edit-location")
    WebElement country;
    @FindBy(css = "div[class='tt-dataset tt-dataset-locations'] div")
    List<WebElement> selectCountry;



    public void selectCountry(String countryName) {
        Actions a = new Actions(driver);
        a.sendKeys(country, countryName).build().perform();
        for (WebElement countries : selectCountry) {
            if (countries.getText().equalsIgnoreCase("Albania")) {
                countries.click();
                break;
            }
        }
    }

    @FindBy(css = "div[class='filter-option']")
    WebElement jobPosition;
    @FindBy(css = "div[role='combobox'] ul li")
    List<WebElement> positions;
    @FindBy(id = "edit-submit")
    WebElement srcForJobs;

    public void selectPosition(String positionJob) {
        jobPosition.click();
        for (WebElement selectPos : positions) {
            if (selectPos.getText().equalsIgnoreCase(positionJob)) {
                selectPos.click();
                break;
            }
        }
        srcForJobs.click();
    }




}
