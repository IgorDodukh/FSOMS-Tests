package pages.magento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BrowserSettings;

/**
 * Created by Ihor on 4/15/2017.
 */
public class MagentoLoginPage extends BrowserSettings{
    private final WebDriver driver;

    @FindBy(id = "username")
    WebElement loginField;

    @FindBy(id = "login")
    WebElement passwordField;

    public MagentoLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void openMagentoAdminPanel(String magentoUrl) {
        log("Open Magento admin panel");
        driver.get(magentoUrl);
    }

    private void setUsername(String username) {
        log("Set Magento username");
        loginField.sendKeys(username);
    }

    private void setPassword(String password) {
        log("Set Magento password");
        passwordField.sendKeys(password);
    }

    private void submitLoginForm() {
        log("Submit Magento login form");
        passwordField.submit();
    }

    public void loginToMagentoAdminPanel(String magentoUrl, String magentoUsername, String magentoPassword) {
        this.openMagentoAdminPanel(magentoUrl);
        this.setUsername(magentoUsername);
        this.setPassword(magentoPassword);
        this.submitLoginForm();
    }
}
