package Pages;

import Settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ihor on 3/22/2017.
 */
public class AddCustomerPage extends BrowserSettings{
    private final WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//Customer Info tab
    @FindBy(id = "customer_first_name")
    WebElement customerFirstNameField;

    @FindBy(id = "customer_last_name")
    WebElement customerLastNameField;

    @FindBy(id = "customer_email")
    WebElement customerEmailField;

    @FindBy(id = "customer_phone")
    WebElement customerPhoneField;

//Billing Address tab
    @FindBy(id = "tabBillingAddresses")
    WebElement billingAddressTab;

    @FindBy(id = "addNewBillingAddressBtn")
    WebElement addNewBillingAddressButton;

    @FindBy(id = "first_name_basic")
    WebElement billingFirstNameField;

    @FindBy(id = "last_name_basic")
    WebElement billingLastNameField;

    @FindBy(id = "phone_basic")
    WebElement billingPhoneField;

    @FindBy(id = "address_basic")
    WebElement billingAddressLine1Field;

    @FindBy(id = "zip_basic")
    WebElement billingZipField;

    @FindBy(id = "city_basic")
    WebElement billingCityField;

//Shipping Address tab
    @FindBy(id = "tabShippingAddresses")
    WebElement shippingAddressTab;

    @FindBy(id = "addNewShippingAddressBtn")
    WebElement addNewShippingAddressButton;

//Payment Methods tab
    @FindBy(id = "tabPaymentMethods")
    WebElement paymentMethodsTab;

    @FindBy(id = "linkAddNewCard")
    WebElement addNewCardButton;

    @FindBy(id = "card_no")
    WebElement cardNumberField;

    @FindBy(xpath = "(//*[@id='card_expYear'])[2]/option[7]")
    WebElement cardExpirationDate;

//Customer Info tab
    private void setCustomerFirstNameField(String firstName) {
        log("Set Customer First Name");
        customerFirstNameField.sendKeys(firstName);
    }

    private void setCustomerLastNameField(String lastName) {
        log("Set Customer Last Name");
        customerLastNameField.sendKeys(lastName);
    }

    private void setCustomerEmailField(String email) {
        log("Set Customer Email Address");
        customerEmailField.sendKeys(email);
    }

    private void setCustomerPhoneField(String phone) {
        log("Set Customer Phone number");
        customerPhoneField.sendKeys(phone);
    }

//Billing Address tab
    private void openBillingAddressTab() {
        log("Open Billing Address tab");
        billingAddressTab.click();
    }

    private void clickAddBillingAddressButton() {
        log("Click 'Add Billing Address' button");
        addNewBillingAddressButton.click();
    }

    private void setBillingFirstNameField(String firstName) {
        log("Set Billing First Name");
        billingFirstNameField.sendKeys(firstName);
    }

    private void setBillingLastNameField(String lastName) {
        log("Set Billing Last Name");
        billingLastNameField.sendKeys(lastName);
    }

    private void setBillingPhoneField(String phone) {
        log("Set Billing Phone number");
        billingPhoneField.sendKeys(phone);
    }

    private void setBillingAddressLine1Field(String addressLine1) {
        log("Set Billing Address line 1");
        billingAddressLine1Field.sendKeys(addressLine1);
    }

    private void setBillingZipField(String zip) {
        log("Set Billing zip code");
        billingZipField.sendKeys(zip);
        openBillingAddressTab();
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) driver ->
                billingCityField.getText().length() != 0);
    }

//Shipping Address tab
    private void openShippingAddressesTab() {
        log("Open Shipping Address tab");
        shippingAddressTab.click();
    }

    private void clickAddShippingAddressButton() {
        log("Click 'Add Shipping Address' button");
        addNewShippingAddressButton.click();
    }

//Payment Methods tab
    private void openPaymentMethodsTab() {
        log("Open Payment Methods tab");
        paymentMethodsTab.click();
    }

    private void clickAddNewCardButton() {
        log("Click 'Add new Card' button");
        addNewCardButton.click();
    }

    private void setCardNumber(String cardNumber) {
        log("Set Card Number");
        cardNumberField.sendKeys(cardNumber);
    }

    private void setCardExpirationDate() {
        log("Set Card Expiration Date");
        cardExpirationDate.click();
    }

    public void setCustomerInfo(String firstName, String lastName, String phone, String email) {
        this.setCustomerFirstNameField(firstName);
        this.setCustomerLastNameField(lastName);
        this.setCustomerPhoneField(phone);
        this.setCustomerEmailField(email);
    }

    public void setCustomerBillingAddress(String firstName, String lastName, String phone, String addressLine, String zip) {
        this.openBillingAddressTab();
        this.clickAddBillingAddressButton();
        this.setBillingFirstNameField(firstName);
        this.setBillingLastNameField(lastName);
        this.setBillingPhoneField(phone);
        this.setBillingAddressLine1Field(addressLine);
        this.setBillingZipField(zip);
    }

    public void setCustomerShippingAddress() {
        this.openShippingAddressesTab();
        this.clickAddShippingAddressButton();
    }

    public void setPaymentMethod(String cardNumber) {
        this.openPaymentMethodsTab();
        this.clickAddNewCardButton();
        this.setCardNumber(cardNumber);
        this.setCardExpirationDate();
    }

}
