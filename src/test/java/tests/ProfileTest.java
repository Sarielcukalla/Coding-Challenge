package tests;

import TestComponents.BaseTest;
import org.junit.Test;
import pageObjects.ProfilePage;

import java.io.IOException;

public class ProfileTest extends BaseTest {

    @Test
    public void createProfileTest() throws IOException, InterruptedException {
        launchApplication();
        landingPage.loginApplication("cukallasariel@gmail.com", "S12345678");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.goToProfile();
        profilePage.scrollWindow("window.scrollBy(0,500)","");
        profilePage.addDocumentsCv();

        closeApp();
    }
}
