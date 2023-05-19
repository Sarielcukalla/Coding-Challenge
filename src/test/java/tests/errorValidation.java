package tests;

import TestComponents.BaseTest;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;

public class errorValidation extends BaseTest {


    @Test
    public void loginError() throws IOException {
        launchApplication();
        landingPage.loginApplication("cukallasarel@gmail.com", "S12345678");
        Assert.assertEquals("Sorry, unrecognized e-mail or password. Please try again.", landingPage.getErrorMessage());
        System.out.println(landingPage.getErrorMessage());
    }
}
