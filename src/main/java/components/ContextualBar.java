package components;

import settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ihor on 3/23/2017.
 */
public class ContextualBar extends BrowserSettings {
    private final WebDriver driver;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    @FindBy(id = "btnSaveAndClose")
    WebElement saveAndCloseButton;

    @FindBy(id = "btnDiscard")
    WebElement discardButton;

    @FindBy(id = "customerMessageBox")
    WebElement customerMessageBox;

    @FindBy(xpath = "//button[@autotest-id='btnOK']")
    WebElement customerMessageBoxOkButton;

    @FindBy(xpath = "//button[@class='primary-button']")
    WebElement messageBoxOkButton;

    public ContextualBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickSaveAndCloseButton() {
        log("Click 'Save and Close' button");
        saveAndCloseButton.click();
    }

    private void clickSaveButton() {
        log("Click 'Save' button");
        saveButton.click();
    }

    private void clickDiscardButton() {
        log("Click 'Discard' button");
        discardButton.click();
    }

    private void confirmCustomerMessageBox() {
        explicitWaitUntilVisible(customerMessageBox);
        customerMessageBoxOkButton.click();
    }

    private void confirmMessageBox() {
        explicitWaitUntilVisible(messageBoxOkButton);
        messageBoxOkButton.click();
    }

    public void saveCustomerChanges() {
        this.clickSaveButton();
        this.confirmCustomerMessageBox();
    }

    public void saveChanges() {
        this.clickSaveButton();
        this.confirmMessageBox();
    }

}
