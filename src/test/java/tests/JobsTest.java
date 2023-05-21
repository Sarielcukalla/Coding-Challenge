package tests;

import TestComponents.BaseTest;
import org.junit.Test;
import pageObjects.*;

import java.io.IOException;


public class JobsTest extends BaseTest {
    @Test
    public void testJobsSubmit() throws InterruptedException, IOException {
        launchApplication();
        landingPage.loginApplication("cukallasariel@gmail.com", "S12345678");
        JobsBoard jobsBoard = new JobsBoard(driver);
        jobsBoard.goToHomePage();
        jobsBoard.goToJobsBoard();
        jobsBoard.selectCountry("Alb");
        jobsBoard.selectPosition("Preschool & Early Childhood");
        FiltersPage filtersPage = new FiltersPage(driver);
        filtersPage.uploadingFilters("Agriculture");
        closeApp();
    }
}
