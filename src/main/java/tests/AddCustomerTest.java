package tests;

import components.ContextualBar;
import components.NavigationMenu;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freestyle.AddCustomerPage;
import settings.BrowserSettings;

/**
 * Created by Ihor on 3/22/2017.
 */
public class AddCustomerTest extends BrowserSettings {
    public  WebDriver driver;
    private NavigationMenu navigationMenu;
    private AddCustomerPage addCustomerPage;
    private ContextualBar contextualBar;
    private LoginToFS loginToFS;

    @Test()
    public void addCustomer() throws InterruptedException {
        driver = getDriver();
        loginToFS = new LoginToFS();
        loginToFS.testSignIn();

        navigationMenu = new NavigationMenu(driver);
        navigationMenu.openAddCustomersPage();
        Assert.assertTrue(driver.getTitle().equals("Add Customer"), "Pag title is not expected");

        addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.setCustomerInfo("First1", "Last1", "2323232323", "Email22@dydacomp.biz");
        addCustomerPage.setCustomerBillingAddress("First", "Last", "Phone", "Address", "10120");
        addCustomerPage.setCustomerShippingAddress();
        addCustomerPage.setPaymentMethod("4111111111111111");

        contextualBar = new ContextualBar(driver);
        contextualBar.saveCustomerChanges();
    }
}
