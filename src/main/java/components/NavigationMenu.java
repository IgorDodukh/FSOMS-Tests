package components;

import settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ihor on 3/22/2017.
 */
public class NavigationMenu extends BrowserSettings{
    private final WebDriver driver;

    @FindBy(className = "glyphicon glyphicon-home")
    WebElement homeNavigationIcon;

//Customers menu
    @FindBy(xpath = "//div[@class='nav-left-item'][1]")
    WebElement customersNavigationIcon;

    @FindBy(xpath = "//div[@class='nav-left-item'][1]/div/a[2]")
    WebElement addCustomerLink;

//Products menu
    @FindBy(xpath = "//div[@class='nav-left-item'][2]")
    WebElement productsNavigationIcon;

    @FindBy(xpath = "//div[@class='nav-left-item'][2]/div/a[2]")
    WebElement addProductLink;

    @FindBy(xpath = "//div[@class='nav-left-item'][2]/div/a[6]")
    WebElement suppliersLink;

//Inventory menu
    @FindBy(xpath = "//div[@class='nav-left-item'][4]")
    WebElement inventoryNavigationIcon;

    @FindBy(xpath = "//div[@class='nav-left-item'][4]/div/a[1]")
    WebElement productInventoryLink;

    @FindBy(xpath = "//div[@class='nav-left-item'][4]/div/a[2]")
    WebElement warehousesLink;

    @FindBy(xpath = "//div[@class='nav-left-item'][4]/div/a[3]")
    WebElement binsLink;

//Setup menu
    @FindBy(xpath = "//div[@class='nav-left-item'][7]")
    WebElement setupNavigationIcon;

    @FindBy(xpath = "//div[@class='nav-left-item'][7]/div/a[1]")
    WebElement settingsLink;

    @FindBy(xpath = "//div[@class='nav-left-item'][7]/div/a[3]")
    WebElement salesChannelsLink;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHome() {
        log("Click 'Home' menu item");
        homeNavigationIcon.click();
    }

    private void clickCustomersMenu() {
        log("Click 'Customers' menu item");
        customersNavigationIcon.click();
    }

    private void clickAddCustomerItem() {
        log("Click 'Add Customer' menu item");
        addCustomerLink.click();
    }

    private void clickProductsMenu() {
        log("Click 'Products' menu item");
        productsNavigationIcon.click();
    }

    private void clickAddProductItem() {
        log("Click 'Add Product' menu item");
        addProductLink.click();
        explicitWaitUntilClickable(productsNavigationIcon);
    }

    private void clickSuppliersItem() {
        log("Click 'Add Product' menu item");
        suppliersLink.click();
    }

    private void clickInventoryMenu() {
        log("Click 'Inventory' menu item");
        inventoryNavigationIcon.click();
    }

    private void clickProductInventoryItem() {
        log("Click 'Product Inventory' menu item");
        productInventoryLink.click();
    }

    private void clickWarehousesItem() {
        log("Click 'Warehouses' menu item");
        warehousesLink.click();
    }

    private void clickBinsItem() {
        log("Click 'Bins' menu item");
        binsLink.click();
    }

    private void clickSetupMenu() {
        log("Click 'Setup' menu item");
        setupNavigationIcon.click();
    }

    private void clickSalesChannelsItem() {
        log("Click 'Sales Channels' menu item");
        salesChannelsLink.click();
    }



    public void openAddCustomersPage() {
        this.clickCustomersMenu();
        this.clickAddCustomerItem();
    }

    public void openAddProductPage() {
        this.clickProductsMenu();
        this.clickAddProductItem();
    }

    public void openSuppliersPage() {
        this.clickProductsMenu();
        this.clickSuppliersItem();
    }

    public void openProductInventoryPage() {
        this.clickInventoryMenu();
        this.clickProductInventoryItem();
    }

    public void openWarehousesPage() {
        this.clickInventoryMenu();
        this.clickWarehousesItem();
    }

    public void openBinsPage() {
        this.clickInventoryMenu();
        this.clickBinsItem();
    }

    public void openSalesChannelsPage() {
        this.clickSetupMenu();
        this.clickSalesChannelsItem();
    }
}