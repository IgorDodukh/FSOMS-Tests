package tests;

import components.ContextualBar;
import components.NavigationMenu;
import pages.freestyle.AddProductPage;
import settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.freestyle.productInventory.*;

/**
 * Created by Ihor on 4/8/2017.
 */
public class AddProductTest extends BrowserSettings {
    public WebDriver driver;
    private NavigationMenu navigationMenu;
    private AddProductPage addProductPage;
    private ContextualBar contextualBar;
    private AddInventoryPage addInventoryPage;
    private ProductInventoryPage productInventoryPage;
    private LoginToFS loginToFS;

    @Test
    public void addProductWithInventory() throws InterruptedException {
        driver = getDriver();
        loginToFS = new LoginToFS();
        loginToFS.testSignIn();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu.openAddProductPage();

        addProductPage = new AddProductPage(driver);
//        Assert.assertTrue(driver.getTitle().equals("Add Product"), "Page title is not expected");

        Assert.assertEquals(driver.getTitle(), "Create Product", "Page title is not expected");

        addProductPage.setProductInfo("sku", "name", "10", "description");
        addProductPage.setProductPrice("10");
        addProductPage.setProductSalesChannel("Call Center");
        addProductPage.setProductSupplier("10");

        contextualBar = new ContextualBar(driver);
        contextualBar.saveCustomerChanges();

        navigationMenu = new NavigationMenu(driver);
        navigationMenu.openProductInventoryPage();
        Assert.assertTrue(driver.getTitle().equals("Product Inventory"), "Pag title is not expected");

        productInventoryPage = new ProductInventoryPage(driver);
        productInventoryPage.openAddInventoryPage("sku");

        addInventoryPage = new AddInventoryPage(driver);
        addInventoryPage.addInventoryInfo("lonNum", "10", "10", "notes");
        addInventoryPage.addInventoryBin("binName", "1");

        contextualBar = new ContextualBar(driver);
        contextualBar.saveChanges();
    }
}
