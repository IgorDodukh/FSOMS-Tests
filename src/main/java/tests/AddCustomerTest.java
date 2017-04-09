package tests;

import components.ContextualBar;
import components.NavigationMenu;
import pages.AddCustomerPage;
import settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Ihor on 3/22/2017.
 */
public class AddCustomerTest extends BrowserSettings {
    public  WebDriver driver;
    private NavigationMenu navigationMenu;
    private AddCustomerPage addCustomerPage;
    private ContextualBar contextualBar;

    @Test
    @Parameters("cardNumber")
    public void addCustomer(String cardNumber) {
        driver = getDriver();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu.openAddCustomersPage();
        Assert.assertTrue(driver.getTitle().equals("Add Customer"), "Pag title is not expected");

        addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.setCustomerInfo("First", "Last", "Phone", "Email");
        addCustomerPage.setCustomerBillingAddress("First", "Last", "Phone", "Address", "Zip");
        addCustomerPage.setCustomerShippingAddress();
        addCustomerPage.setPaymentMethod(cardNumber);

        contextualBar = new ContextualBar(driver);
        contextualBar.saveCustomerChanges();
    }
}
