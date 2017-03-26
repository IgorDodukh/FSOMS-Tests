package Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ihor on 3/22/2017.
 */
public class NavigationMenu {
    private WebDriver driver;

    @FindBy(className = "glyphicon glyphicon-home")
    WebElement homeNavigationIcon;

//    @FindBy(className = "glyphicon glyphicon-user")
//    WebElement customerNavigationIcon;

    @FindBy(xpath = "//div[@class='nav-left-item'][1]")
    WebElement customerNavigationIcon;

    @FindBy(partialLinkText = "CreateCustomerView")
    WebElement addCustomerLink;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHome() {
        homeNavigationIcon.click();
    }

    public void clickAddCustomerLink() {
        customerNavigationIcon.click();
        addCustomerLink.click();
    }
}