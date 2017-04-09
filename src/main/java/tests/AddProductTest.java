package tests;

import сomponents.ContextualBar;
import сomponents.NavigationMenu;
import pages.AddProductPage;
import pages.productInventory.AddInventoryPage;
import pages.productInventory.ProductInventoryPage;
import settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Ihor on 4/8/2017.
 */
public class AddProductTest extends BrowserSettings {
    public WebDriver driver;
    private NavigationMenu navigationMenu;
    private AddProductPage addProductPage;
    private ContextualBar contextualBar;
    private ProductInventoryPage productInventoryPage;
    private AddInventoryPage addInventoryPage;

    @Test
    public void addProduct() {
        driver = getDriver();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu.openAddProductPage();
        Assert.assertTrue(driver.getTitle().equals("Add Product"), "Pag title is not expected");

        addProductPage = new AddProductPage(driver);
        addProductPage.setProductInfo("sku", "name", "weigth", "description");
        addProductPage.setProductPrice("price");
        addProductPage.setProductSalesChannel("channel name");
        addProductPage.setProductSupplier("unit cost");

        contextualBar = new ContextualBar(driver);
        contextualBar.saveCustomerChanges();
    }

    @Test
    public void addProductInventory() {
        driver = getDriver();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu.openProductInventoryPage();
        Assert.assertTrue(driver.getTitle().equals("Product Inventory"), "Pag title is not expected");

        productInventoryPage = new ProductInventoryPage(driver);
        productInventoryPage.openAddInventoryPage("sku");

        addInventoryPage = new AddInventoryPage(driver);
        addInventoryPage.addInventoryInfo("lonNum", "unitCost", "qty", "notes");
        addInventoryPage.addInventoryBin("binName", "binPriority");

        contextualBar = new ContextualBar(driver);
        contextualBar.saveChanges();
    }
}
