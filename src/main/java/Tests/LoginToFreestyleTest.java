package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ihor on 3/22/2017.
 */
public class LoginToFreestyleTest extends BrowserSettings {
    public  WebDriver driver = getDriver();
    private HomePage homePageObject;
    private LoginPage loginPageObject;

    private String userLogin = "IgorQA@dydacomp.biz";
    private String userPassword = "Password#1";
//
//    @BeforeMethod(alwaysRun = true)
//    public void openLoginPage() {
//        loginPageObject = new LoginPage(driver).open();
//    }

    @Test
    public void testSignIn() {
        log("Create Login Page object");
        loginPageObject = new LoginPage(getDriver());

        log("Verify login page title");
        String loginPageTitle = loginPageObject.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Freestyle O.M.S.™ Login"), "Not expected page opened");

        log("Login to application");
        loginPageObject.loginToFreestyle(userLogin, userPassword);

        homePageObject = new HomePage(getDriver());

        log("Verify login page title");
        Assert.assertTrue(homePageObject.getHomePageDashboardUserName().contains("Clint"));
    }
}
