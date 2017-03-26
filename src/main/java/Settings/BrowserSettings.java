package Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by Ihor on 3/22/2017.
 */
public class BrowserSettings {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private String browser = System.getProperty("browser");
    private String reportsDirectory = System.getProperty("reportsDirectory");
    private String reportsPath = System.getProperty("reportsPath");

    //    List of Environments
    public static final ArrayList<String> fsEnvironment = new ArrayList<>(
            Arrays.asList("https://qa01.freestylecommerce.info/web",
                    "https://qa03.freestylecommerce.info/web",
                    "https://qa05.freestylecommerce.info/web",
                    "https://my.freestylecommerce.com/web"));

    @BeforeSuite
    public void setUp() {
        log("Initialize WebDriver");
        String chromeDriverPath = System.getProperty("chrome.driver.executable");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://qa05.freestylecommerce.info/web");
    }

    @AfterSuite
    public void tearDown() {
        log("Quit from WebDriver");
        driver.quit();
    }

    public static void log(String logMessage) {
        Reporter.log(logMessage + "<br>");
    }

    public void explicitWaitUntilVisible(WebElement locator, String textMessage) {
        log("Waiting appearing of element: " + locator.toString());
        FluentWait wait = new WebDriverWait(driver, 20).withMessage(textMessage);
        wait.until((Function) ExpectedConditions.visibilityOf(locator));
    }

    public void explicitWaitUntilUnvisible(WebElement locator, String textMessage) {
        log("Waiting disappearing of element: " + locator.toString());
        FluentWait wait = new WebDriverWait(driver, 20).withMessage(textMessage);
        wait.until((Function) ExpectedConditions.not(ExpectedConditions.visibilityOf(locator)));
    }
}
