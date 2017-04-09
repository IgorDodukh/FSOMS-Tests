package pages.productInventory;

import settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Ihor on 4/9/2017.
 */
public class AddInventoryPage extends BrowserSettings {
    private final WebDriver driver;

    public AddInventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtLotNum")
    WebElement lotNumberField;

    @FindBy(id = "txtUnitCost")
    WebElement unitCostField;

    @FindBy(xpath = "//select[@id='bin_1']//option[2]")
    WebElement binDropdownAddNewBinButton;

    @FindBy(id = "txtBinName")
    WebElement binNameField;

    @FindBy(xpath = "//select[@id='selectBinType']/option[2]")
    WebElement binPickBinDropdown;

    @FindBy(id = "binPriority")
    WebElement binPriorityField;

    @FindBy(id = "quantity_1")
    WebElement productQuantityField;

    @FindBy(xpath = "//form/div[6]/*")
    WebElement productQuantityValue;

    @FindBy(id = "txtComment")
    WebElement productNotesField;

    @FindBy(id = "save_BinAddClone")
    WebElement saveBinButton;

    private void setLotNumber(String lotNumber) {
        log("Add Lot number");
        lotNumberField.sendKeys(lotNumber);
    }

    private void setUnitCost(String unitCost) {
        log("Add unit cost");
        unitCostField.sendKeys(unitCost);
    }

    private void openAddBinForm() {
        log("Open 'Add Bin' form");
        binDropdownAddNewBinButton.click();
        explicitWaitUntilVisible(binNameField);
    }

    private void addBinName(String binName) {
        log("Add Bin name");
        binNameField.sendKeys(binName);
    }

    private void setBinType() {
        log("Select Bin type");
        binPickBinDropdown.click();
    }

    private void setBinPriority(String binPriority) {
        log("Add Bin priority");
        binPriorityField.sendKeys(binPriority);
    }

    private void saveBin() {
        log("Save Bin");
        saveBinButton.click();
        final Wait<WebDriver> wait2 = new WebDriverWait(driver, 20).withMessage("Bin creating popup was not hidden");
        wait2.until(ExpectedConditions.elementToBeClickable(lotNumberField));
    }

    private void addProductQty(String inventoryQty) {
        log("Add qty value");
        productQuantityField.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productQuantityField.sendKeys(inventoryQty);
        productNotesField.click();

        String qtyValue = productQuantityValue.getText();
        Assert.assertEquals(qtyValue, inventoryQty + ".00", "Incorrect qty value is displayed");
    }

    private void addNotes(String inventoryNotes) {
        log("Add Notes");
        productNotesField.sendKeys(inventoryNotes);
    }

    public void addInventoryInfo(String lotNumber, String unitCost, String qty, String notes) {
        this.setLotNumber(lotNumber);
        this.setUnitCost(unitCost);
        this.addProductQty(qty);
        this.addNotes(notes);
    }

    public void addInventoryBin(String binName, String binPriority) {
        this.openAddBinForm();
        this.addBinName(binName);
        this.setBinType();
        this.setBinPriority(binPriority);
        this.saveBin();
    }
}
