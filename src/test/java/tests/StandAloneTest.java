package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.teachaway.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.findElement(By.id("login")).click();
        driver.findElement(By.name("username")).sendKeys("cukallasariel@gmail.com");
        driver.findElement(By.name("password")).sendKeys("S12345678");
        driver.findElement(By.id("login_action")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("(//img[@alt='Teach Away logo'])[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ub-emb-close")));
        driver.findElement(By.cssSelector(".ub-emb-close")).click();
        driver.findElement(By.id("hs-eu-confirmation-button")).click();


        Actions a = new Actions(driver);
        WebElement job = driver.findElement(By.cssSelector("span[title='Jobs']"));
        a.moveToElement(job).build().perform();

        driver.findElement(By.linkText("Job Board")).click();

        String msgJobs = driver.findElement(By.cssSelector("div[class='page-title'] h1 span")).getText();
        Thread.sleep(2000);
        Assert.assertEquals("Find Teaching Jobs Abroad", msgJobs);

        driver.findElement(By.id("edit-location")).sendKeys("Alb");
        List<WebElement> countries = driver.findElements(By.cssSelector("div[class='tt-dataset tt-dataset-locations'] div"));

        for (WebElement country : countries) {
            if (country.getText().equalsIgnoreCase("Albania")) {
                country.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("div[class='filter-option']")).click();
        driver.findElement(By.linkText("College & University")).click();
        driver.findElement(By.id("edit-submit")).click();

        driver.findElement(By.cssSelector("span[title='Tefl']")).click();
        driver.findElement(By.xpath("//a[@title='TEFL Courses']")).click();
        driver.findElement(By.cssSelector("a[class='btn btn-cta-front']")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("firstname-7e41dfc9-38a4-4a26-84a2-e9b31a7847e7_6371")).sendKeys("Sari");
        driver.findElement(By.id("lastname-7e41dfc9-38a4-4a26-84a2-e9b31a7847e7_6371")).sendKeys("Cukalla");
        driver.findElement(By.xpath("//input[@autocomplete='email']")).sendKeys("cukallasariel@gmail.com");
        driver.findElement(By.cssSelector("input[value='REGISTER']")).click();
        String msgConf = driver.findElement(By.xpath("//p[text()='Thank you! Your registration is confirmed.']")).getText();
        Assert.assertEquals( msgConf,"Thank you! Your registration is confirmed.");
    }
}
