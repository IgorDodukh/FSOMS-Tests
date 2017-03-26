package Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ihor on 3/22/2017.
 */
public class NavigationMenu {
    private final WebDriver driver;

    @FindBy(className = "glyphicon glyphicon-home")
    WebElement homeNavigationIcon;

    @FindBy(xpath = "//div[@class='nav-left-item'][1]")
    WebElement customerNavigationIcon;

    @FindBy(xpath = "//div[@class='nav-left-item'][1]/div/a[2]")
    WebElement addCustomerLink;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHome() {
        homeNavigationIcon.click();
    }

    private void clickCustomersLink() {
        customerNavigationIcon.click();
    }

    private void clickAddCustomerItem() {
        addCustomerLink.click();
    }

    public void openAddCustomersPage() {
        this.clickCustomersLink();
        this.clickAddCustomerItem();
    }
}