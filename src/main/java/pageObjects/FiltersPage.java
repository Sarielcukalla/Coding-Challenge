package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FiltersPage extends abstractComponent {
    WebDriver driver;

    public FiltersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;


    }

    @FindBy(id = "edit-modal-filters")
    WebElement filters;
    @FindBy(id = "edit-subject--2")
    WebElement subjectFilters;
    @FindBy(css = "label[for='edit-level-middle-school-level']")
    WebElement middleSchoolLv;
    @FindBy(id = "edit-submit--2")
    WebElement uploadResults;

    public void uploadingFilters(String subjectName) {
        filters.click();
        subjectFilters.sendKeys(subjectName);
        middleSchoolLv.click();
        uploadResults.click();
    }


}
