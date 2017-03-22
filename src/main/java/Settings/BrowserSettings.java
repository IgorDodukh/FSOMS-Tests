package Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ihor on 3/22/2017.
 */
public class BrowserSettings {
    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;

    private String browser = System.getProperty("browser");
    private String reportsDirectory = System.getProperty("reportsDirectory");
    private String reportsPath = System.getProperty("reportsPath");

    //    List of Environments
    public static final ArrayList<String> fsEnvironment = new ArrayList<>(
            Arrays.asList("https://qa01.freestylecommerce.info/web",
                    "https://qa03.freestylecommerce.info/web",
                    "https://qa05.freestylecommerce.info/web",
                    "https://my.freestylecommerce.com/web"));

    @BeforeClass
    public void setUp() {
        log("Initialize WebDriver");
        String chromeDriverPath = System.getProperty("chrome.driver.executable");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://qa05.freestylecommerce.info/web");
    }

    @AfterClass
    public void tearDown() {
        log("Quit from WebDriver");
        driver.quit();
    }

    protected void log(String logMessage) {
        Reporter.log(logMessage + "<br>");
    }
}
