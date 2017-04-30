package pages.freestyle;

import settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ihor on 3/22/2017.
 */
public class HomePage extends BrowserSettings{
    public final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='home-section']//h4")
    WebElement homePageUserName;

    public String getHomePageDashboardUserName() {
        log("Get username on the Home page");
        return homePageUserName.getText();
    }
}
