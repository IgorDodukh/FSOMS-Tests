package pages.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.BrowserSettings;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Ihor on 4/15/2017.
 */
public class ConfigurationsPage extends BrowserSettings {
    private final WebDriver driver;

    @FindBy(id = "message-popup-window")
    WebElement messageBox;

    @FindBy(xpath = "//div[@id='message-popup-window']//a/span")
    WebElement messageBoxCloseButton;

    @FindBy(id = "freestyle_advancedexport_api_api_username")
    WebElement usernameField;

    @FindBy(id = "freestyle_advancedexport_api_api_password")
    WebElement passwordField;

    @FindBy(id = "freestyle_advancedexport_api_api_authorization_url")
    WebElement authenticationUrlField;

    @FindBy(id = "freestyle_advancedexport_api_api_service_url")
    WebElement notificationUrlField;

    @FindBy(id = "freestyle_advancedexport_queue_queue_service_url")
    WebElement queueServiceField;

    @FindBy(id = "freestyle_advancedexport_settings_chanel_id")
    WebElement channelIdField;

    @FindBy(xpath = "//div[3]/div/table/tbody/tr/td[2]/button")
    WebElement saveConfigurationSettingsButton;

    @FindBy(xpath = "//div[@class='main-col-inner']//button[@class='scalable save']")
    WebElement saveConfigurationSettingsScallableButton;

    @FindBy(xpath = "//div[@class='switcher']//select")
    WebElement websitesDropdown;

    public ConfigurationsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void checkMessageBoxPresence() {
        log("Check MessageBox presence");
        try{
            final Wait<WebDriver> wait2 = new WebDriverWait(driver, 2).withMessage("Popup message was not found");
            wait2.until(ExpectedConditions.visibilityOf(messageBox));
            messageBoxCloseButton.click();
        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("Message box was not found");
        }
    }

    private void setUsername(String username) {
        log("Set username");
        usernameField.sendKeys(username);
    }

    private void setPassword(String password) {
        log("Set password");
        usernameField.sendKeys(password);
    }

    private void setAuthenticationUrl(String authenticationUrl) {
        log("Set Authentication Url");
        authenticationUrlField.sendKeys(authenticationUrl);
    }

    private void setNotificationUrl(String notificationUrl) {
        log("Set Notification Url");
        notificationUrlField.sendKeys(notificationUrl);
    }

    private void setQueueServiceUrl(String queueServiceUrl) {
        log("Set Queue Service Url");
        queueServiceField.sendKeys(queueServiceUrl);
    }

    private void saveAdvancedExportSettings() {
        log("Save Advanced Export settings");
        try {
            saveConfigurationSettingsButton.click();
        }catch (Exception e){
            saveConfigurationSettingsScallableButton.click();
        }
    }

    private void openMainWebsiteSettings() {
        log("Open 'Main Website' settings page");
        websitesDropdown.click();

        String dropdownValue;

        for (int i = 1; i <= 100; i++){
            By magentoWebSiteOptionLocator = By.xpath("//select[@id='store_switcher']/option[" + i + "]");
            dropdownValue = driver.findElement(magentoWebSiteOptionLocator).getText();
            if (Objects.equals(dropdownValue, "          Main Website      ")) {
                driver.findElement(magentoWebSiteOptionLocator).click();
                break;
            }
        }
    }

    private void setChannelId(String channelId) {
        log("Set channel Id");
        channelIdField.clear();
        channelIdField.sendKeys(channelId);
    }

    private void saveMainWebsiteSettings() {
        log("Save Main Website settings");
        saveConfigurationSettingsScallableButton.click();
        explicitWaitUntilClickable(saveConfigurationSettingsScallableButton);
    }

    public void setAdvancedExportSettings(String username, String pass, String authUrl, String notifUrl, String queueUrl) {
        this.checkMessageBoxPresence();
        this.setUsername(username);
        this.setPassword(pass);
        this.setAuthenticationUrl(authUrl);
        this.setNotificationUrl(notifUrl);
        this.setQueueServiceUrl(queueUrl);
        this.saveAdvancedExportSettings();
    }

    public void setChannelIdValue(String channelIdValue) {
        this.openMainWebsiteSettings();
        this.setChannelId(channelIdValue);
        this.saveMainWebsiteSettings();
    }



}
