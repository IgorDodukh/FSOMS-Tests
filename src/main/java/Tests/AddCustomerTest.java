package Tests;

import Components.NavigationMenu;
import Settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Ihor on 3/22/2017.
 */
public class AddCustomerTest extends BrowserSettings {
    public  WebDriver driver;
    private NavigationMenu navigationMenu;

    @Test
    public void openAddCustomersPage() {
        driver = getDriver();
        log("Open 'Add Customer' page");
        navigationMenu = new NavigationMenu(driver);
        navigationMenu.openAddCustomersPage();
    }
}
