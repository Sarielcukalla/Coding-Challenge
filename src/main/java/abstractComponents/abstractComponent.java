package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.JobsBoard;
import pageObjects.TeflPage;

import java.time.Duration;

public class abstractComponent {
    WebDriver driver;

    public abstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[title='Jobs']")
    WebElement jobsAction;
    @FindBy(linkText = "Job Board")
    WebElement jobsBoardBtn;

    @FindBy(css = "span[title='Tefl']")
    WebElement teflBtn;
    @FindBy(xpath = "//a[@title='TEFL Courses']")
    WebElement teflCourses;


    public JobsBoard goToJobsBoard() {
        Actions a = new Actions(driver);
        a.moveToElement(jobsAction).build().perform();
        jobsBoardBtn.click();
        JobsBoard jobsBoard = new JobsBoard(driver);
        return jobsBoard;
    }

    public TeflPage goToTefl() {
        Actions a = new Actions(driver);
        a.moveToElement(teflBtn).build().perform();
        teflCourses.click();
        TeflPage teflPage = new TeflPage(driver);
        return teflPage;
    }

    public void waitForElementToAppear(By findby) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
    }

    public void waitForWebElementToAppear(WebElement findby) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findby));
    }

}
