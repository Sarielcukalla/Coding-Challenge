package tests;

import TestComponents.BaseTest;
import org.junit.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.TeflPage;

import java.io.IOException;

public class TeflTest extends BaseTest {
    @Test
    public void testAppTefl() throws InterruptedException, IOException {
        launchApplication();

        landingPage.goTo();
        landingPage.loginApplication("cukallasariel@gmail.com", "S12345678");
        HomePage page = new HomePage(driver);
        page.goToHomePage();
        TeflPage teflPage = new TeflPage(driver);
        teflPage.goToTefl();
        teflPage.registerTefl("sari", "cukalla", "cukallasariel@gmail.com");
        teflPage.submitRegistration();
        String confirmMessage = teflPage.submitRegistration().GetConfMess();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you! Your registration is confirmed."));
        System.out.println(confirmMessage);

        closeApp();

    }
}
