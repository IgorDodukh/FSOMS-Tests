package Pages;

import Settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Ihor on 3/22/2017.
 */
public class LoginPage extends BrowserSettings {
    private final WebDriver driver;

    @FindBy(className="sr-only")
    WebElement titleText;

    @FindBy(id = "userName")
    WebElement usernameField;

    @FindBy(id = "userPassword")
    WebElement passwordField;

    @FindBy(id = "btn_Logon")
    WebElement loginButton;

    @FindBy(id = "msgRequestProcessing")
    WebElement processBar;

    @FindBy(id = "msgActiveSession")
    WebElement activeSessionMessage;

    @FindBy(xpath = "//div[@id=\"msgActiveSession\"]//div[2]/button")
    WebElement continueLoginButton;

    @FindBy(id = "msgServerError")
    WebElement loginErrorMessage;

//    private final By loginFormTitle = By.className("sr-only");
//    private final By emailInputLocator = By.className("userName");
//    private final By passwordInputLocator = By.xpath("//input[@name='UserPassword']");
//    private final By loginButtonLocator = By.xpath("//input[@value='Login']");
//    private final By msgBox = By.xpath("//div[@id='dydacomp_messagebox']");
//    private final By msgBoxOkButton = By.xpath("//button[@autotest-id='btnOK']");
//    private final By siteLogoIconLocator = By.xpath("//img[@id='logoIcon']");

//    private final By activeSessionMessage = By.id("msgActiveSession");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method which creates all WebElements
        PageFactory.initElements(driver, this);
    }

    private void setUserName(String strUserName) {
        usernameField.sendKeys(strUserName);
    }

    private void setPassword(String strPassword) {
        passwordField.sendKeys(strPassword);
    }

    private void clickLogin() throws InterruptedException {
        log("Click Login button");
        loginButton.click();
        try {
            log("Wait appearing of element: " + activeSessionMessage);
            Thread.sleep(1000);
            Assert.assertTrue(activeSessionMessage.isDisplayed());
            log("Click 'Continue Login' button");
            continueLoginButton.click();
            log("User is logging");
        } catch (AssertionError e) {
            log("User is logging");
        }
    }

    public String getLoginTitle() {
        return titleText.getText();
    }

//    public LoginPage open() {
//        log("Open login page");
//        driver.get("https://qa05.freestylecommerce.info/web");
//        return this;
//    }

    public void loginToFreestyle(String username, String password) throws InterruptedException {
        this.setUserName(username);
        this.setPassword(password);
        this.clickLogin();
    }

}
