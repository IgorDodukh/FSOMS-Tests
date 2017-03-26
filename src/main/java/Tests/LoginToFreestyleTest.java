package Tests;

import Components.NavigationMenu;
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
    public  WebDriver driver;
    private HomePage homePageObject;
    private LoginPage loginPageObject;
    private NavigationMenu navigationMenu;

    private String userLogin = "IgorQA@dydacomp.biz";
    private String userPassword = "Password#1";

    @Test
    public void testSignIn() throws InterruptedException {
        driver = getDriver();
        log("Create Login Page object");
        loginPageObject = new LoginPage(driver);

        log("Verify login page title");
        String loginPageTitle = loginPageObject.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Freestyle O.M.S.™ Login"), "Not expected page opened");

        log("Login to application");
        loginPageObject.loginToFreestyle(userLogin, userPassword);

        homePageObject = new HomePage(driver);

        log("Verify home page greeting 'Hi, user'");
        Assert.assertTrue(homePageObject.getHomePageDashboardUserName().contains("Hi, "));
    }

    @Test
    public void openAddCustomersPage() {
        log("Open 'Add Customer' page");
        navigationMenu = new NavigationMenu(driver);
        navigationMenu.openAddCustomersPage();
    }
}
