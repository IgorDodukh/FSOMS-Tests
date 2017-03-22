package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Reporter.log;

/**
 * Created by Ihor on 3/22/2017.
 */
public class LoginPage {
    public final WebDriver driver;

    @FindBy(className="sr-only")
    WebElement titleText;

    @FindBy(id = "userName")
    WebElement usernameField;

    @FindBy(id = "userPassword")
    WebElement passwordField;

    @FindBy(id = "btn_Logon")
    WebElement loginButton;

    @FindBy(id = "msgRequestProcessing")
    WebElement processingBar;

    @FindBy(id = "msgActiveSession")
    WebElement activeSessionMessage;

    @FindBy(xpath = "//div[@id=\"msgActiveSession\"]//div[2]/button")
    WebElement continueLoginButton;

    @FindBy(id = "msgServerError")
    WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        //This initElements method which creates all WebElements
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String strUserName) {
        usernameField.sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        passwordField.sendKeys(strPassword);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getLoginTitle() {
        return titleText.getText();
    }

    public LoginPage open() {
        log("Open login page");
        driver.get("https://qa05.freestylecommerce.info/web");
        return this;
    }

    public void loginToFreestyle(String username, String password) {
        this.setUserName(username);
        this.setPassword(password);
        this.clickLogin();
    }
}
