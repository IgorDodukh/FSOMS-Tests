package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ihor on 3/22/2017.
 */
public class HomePage {
    public final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"home-section\"]//h4")
    WebElement homePageUserName;

    public String getHomePageDashboardUserName() {
        return homePageUserName.getText();
    }
}