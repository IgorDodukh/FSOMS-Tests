package pages.freestyle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BrowserSettings;

/**
 * Created by Ihor on 4/15/2017.
 */
public class SalesChannelsPage extends BrowserSettings {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='dataTables_filter']//input")
    WebElement filterByField;

    @FindBy(xpath = "//table/tbody//tr[1]/td[2]")
    WebElement firstFoundChannelRow;

    @FindBy(xpath = "//table/tbody//tr[1]//input[@name='view_salesChannel']")
    WebElement viewChannelButton;

    @FindBy(xpath = "//aside[@id='leftNav']//ul[1]/li/a")
    WebElement channelOverviewTab;

    @FindBy(xpath = "//input[@id='txtChannelId']")
    WebElement channelIdValue;

    public SalesChannelsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void searchChannel(String channelName) {
        log("Search needed Magento channel");
//        String channelName = Controller.magentoIndexName.replace("qatestlab", "");
        filterByField.sendKeys(channelName);
        filterByField.sendKeys(Keys.ENTER);
        explicitWaitUntilClickable(filterByField);
    }

    private void viewFoundChannel() {
        log("Open first found Magento channel");
        firstFoundChannelRow.click();
        viewChannelButton.click();
        explicitWaitUntilClickable(channelOverviewTab);
    }

    private String getChannelIdValue() {
        log("Get channel ID");
        return channelIdValue.getAttribute("value");
    }

    public void getMagentoChannelId(String channelName) {
        this.searchChannel(channelName);
        this.viewFoundChannel();
        this.getChannelIdValue();
    }
}
