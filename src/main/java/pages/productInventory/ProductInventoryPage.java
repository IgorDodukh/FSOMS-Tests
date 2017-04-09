package pages.productInventory;

import settings.BrowserSettings;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Ihor on 4/9/2017.
 */
public class ProductInventoryPage extends BrowserSettings {
    private final WebDriver driver;

    public ProductInventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label/input")
    WebElement filterByField;

    @FindBy(xpath = "//tr[1]/td[3]")
    WebElement firstProductRow;

    @FindBy(xpath = "//tr[1]/td[2]")
    WebElement firstProductSKU;

    @FindBy(xpath = "//tr[1]//button[@id='create_Inventory']")
    WebElement firstProductAddButton;

    private void findProduct(String productSku) {
        log("Find product " + productSku);
        filterByField.sendKeys(productSku);
        filterByField.sendKeys(Keys.ENTER);
        explicitWaitUntilVisible(firstProductSKU);
        Assert.assertEquals(firstProductSKU.getText(), productSku, "Found Product has not expected SKU");
    }

    private void selectFirstFoundProduct() {
        log("Select first found Product");
        firstProductRow.click();
    }

    private void clickAddButton() {
        log("Click 'Add' button");
        firstProductAddButton.click();
    }

    public void openAddInventoryPage(String productSku) {
        this.findProduct(productSku);
        this.selectFirstFoundProduct();
        this.clickAddButton();
    }
}
