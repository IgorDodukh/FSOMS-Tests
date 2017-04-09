package Pages;

import Settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ihor on 4/8/2017.
 */
public class AddProductPage extends BrowserSettings {
    private final WebDriver driver;

    public AddProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//Product info tab
    @FindBy(name = "productInfo_Sku")
    WebElement productSkuField;

    @FindBy(name = "productInfo_Name")
    WebElement productNameField;

    @FindBy(name = "productInfo_WeightLB")
    WebElement productWeightField;

    @FindBy(id = "productInfo_Desc")
    WebElement productShortDescriptionField;

//Pricing tab
    @FindBy(id = "pricingTab")
    WebElement productPricingTab;

    @FindBy(id = "retail-price")
    WebElement productRetailPriceField;

//Sales Channels tab
    @FindBy(id = "salesChannelsTab")
    WebElement productSalesChannelTab;

    @FindBy(id = "control_autoCompleteSingle_1")
    WebElement salesChannelNameField;

    @FindBy(className = "ui-menu-item")
    WebElement salesChannelTooltip;

    @FindBy(xpath = "//*[@id='salesChannelsTable']//img[2]")
    WebElement salesChannelAddButton;

//Suppliers tab
    @FindBy(id = "suppliersTab")
    WebElement productSuppliersTab;

    @FindBy(id = "add_supplier")
    WebElement addSupplierButton;

    @FindBy(name = "chxBox_supplier")
    WebElement selectSupplierCheckbox;

    @FindBy(id = "add_selected_supplier")
    WebElement addSelectedSupplierButton;

    @FindBy(xpath = "//*[@id='SuppliersItemsTable']/tbody/tr")
    WebElement addedSupplierRow;

    @FindBy(xpath = "//*[@id='rowActions']/input[1]")
    WebElement addedSupplierEditButton;

    @FindBy(id = "li_Warehouse")
    WebElement warehouseTab;

    @FindBy(id = "txtPrice")
    WebElement unitCostField;

    @FindBy(id = "add_item")
    WebElement unitCostAddButton;

    @FindBy(id = "btnOkButton1")
    WebElement supplierSaveOkButton;

//Product info tab
    private void setProductSku(String productSku) {
        log("Set Product SKU");
        productSkuField.sendKeys(productSku);
    }

    private void setProductName(String productName) {
        log("Set Product Name");
        productNameField.sendKeys(productName);
    }

    private void setProductWeight(String productWeight) {
        log("Set Product Weight");
        productWeightField.sendKeys(productWeight);
    }

    private void setProductDescription(String productDescription) {
        log("Set Product Description");
        productShortDescriptionField.sendKeys(productDescription);
    }

//Product prices tab
    private void openPricesTab() {
        log("Open Prices tab");
        productPricingTab.click();
    }

    private void setProductRetailPrice(String productRetailPrice) {
        log("Set Product SKU");
        driver.switchTo().frame("pricingIframe");
        productRetailPriceField.sendKeys(productRetailPrice);
        driver.switchTo().defaultContent();
    }

//Sales Channels tab
    private void openSalesChannelsTab() {
        log("Open Sales Channels tab");
        productSalesChannelTab.click();
    }

    private void addSalesChannelName(String channelName) {
        log("Type sales channel name");
        salesChannelNameField.sendKeys(channelName);
        log("Waiting 'found channels' tooltip");
        explicitWaitUntilVisible(salesChannelTooltip);
    }

    private void addFoundSalesChannel() {
        log("Click on found sales channel");
        salesChannelTooltip.click();
        log("Add found channel");
        salesChannelAddButton.click();
    }

//Suppliers tab
    private void openSuppliersTab() {
        log("Open Suppliers tab");
        productSuppliersTab.click();
    }

    private void openSuppliersList() {
        log("Click 'Add Supplier' button");
        addSupplierButton.click();
        log("Waiting appearing 'Add Supplier' dialog");
        explicitWaitUntilVisible(selectSupplierCheckbox);
        selectSupplierCheckbox.click();
    }

    private void selectSupplierFromList() {
        log("Select Supplier from the list");
        selectSupplierCheckbox.click();
    }

    private void addSelectedSupplier() {
        log("Add selected supplier");
        addSelectedSupplierButton.click();
        addedSupplierRow.click();
    }

    private void openAddedSupplier() {
        log("Open Supplier in edit mode");
        addedSupplierEditButton.click();
        warehouseTab.click();
    }

    private void addSupplierUnitCost(String unitCost) {
        log("Add Supplier Unit Cost");
        unitCostField.sendKeys(unitCost);
        unitCostAddButton.click();
    }

    private void saveSupplierChanges() {
        supplierSaveOkButton.click();
    }

    public void setProductInfo(String productSku, String productName, String productWeight, String productDescription) {
        this.setProductSku(productSku);
        this.setProductName(productName);
        this.setProductWeight(productWeight);
        this.setProductDescription(productDescription);
    }

    public void setProductPrice(String productRetailPrice) {
        this.openPricesTab();
        this.setProductRetailPrice(productRetailPrice);
    }

    public void setProductSalesChannel(String channelName) {
        this.openSalesChannelsTab();
        this.addSalesChannelName(channelName);
        this.addFoundSalesChannel();
    }

    public void setProductSupplier(String unitCost) {
        this.openSuppliersTab();
        this.openSuppliersList();
        this.selectSupplierFromList();
        this.addSelectedSupplier();
        this.openAddedSupplier();
        this.addSupplierUnitCost(unitCost);
        this.saveSupplierChanges();
    }
}

