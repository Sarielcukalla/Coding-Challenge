package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.JobsBoard;
import pageObjects.ProfilePage;
import pageObjects.TeflPage;

import java.time.Duration;

public class abstractComponent {
    WebDriver driver;

    public abstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//img[@alt='Teach Away logo'])[1]")
    WebElement logoBtn;
    //    @FindBy(css = ".ub-emb-close")
//    WebElement btnClose;
    @FindBy(id = "hs-eu-confirmation-button")
    WebElement alertConf;

    By userProfile = By.cssSelector(".user-menu");

    @FindBy(css = "span[title='Jobs']")
    WebElement jobsAction;
    @FindBy(linkText = "Job Board")
    WebElement jobsBoardBtn;

    @FindBy(css = "span[title='Tefl']")
    WebElement teflBtn;
    @FindBy(xpath = "//a[@title='TEFL Courses']")
    WebElement teflCourses;
    @FindBy(xpath = "//a[text()='PROFILE']")
    WebElement profile;

    public ProfilePage goToProfile() {
        waitForWebElementToAppear(profile);
        profile.click();
        waitForWebElementToAppear(alertConf);
        alertConf.click();
        ProfilePage profilePage = new ProfilePage(driver);
        return profilePage;

    }


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


    public HomePage goToHomePage() {
        waitForElementToAppear(userProfile);
        logoBtn.click();
//        waitForWebElementToAppear(btnClose);
//        btnClose.click();
        waitForWebElementToAppear(alertConf);
        alertConf.click();
        HomePage homePage = new HomePage(driver);
        return homePage;
    }

    public void scrollWindow(String script, String args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, args);
    }

    public void waitForElementToAppear(By findby) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

}
