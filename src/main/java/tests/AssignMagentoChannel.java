package tests;

import components.NavigationMenu;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.freestyle.SalesChannelsPage;
import pages.magento.ConfigurationsPage;
import pages.magento.MagentoLoginPage;
import settings.BrowserSettings;

/**
 * Created by Ihor on 4/15/2017.
 */
public class AssignMagentoChannel extends BrowserSettings {
    public WebDriver driver;

    private NavigationMenu navigationMenu;
    private SalesChannelsPage salesChannelsPage;
    private MagentoLoginPage magentoLoginPage;
    private ConfigurationsPage configurationsPage;
    private LoginToFS loginToFS;

    @Test
    public void syncMagentoWithFS() throws InterruptedException {
        driver = getDriver();
        loginToFS = new LoginToFS();
        loginToFS.testSignIn();

        navigationMenu = new NavigationMenu(driver);
        navigationMenu.openSalesChannelsPage();

        salesChannelsPage = new SalesChannelsPage(driver);
        salesChannelsPage.getMagentoChannelId("magento05");

        magentoLoginPage = new MagentoLoginPage(driver);
        magentoLoginPage.loginToMagentoAdminPanel("magentoUrl", "username", "password");

        configurationsPage = new ConfigurationsPage(driver);
        configurationsPage.setAdvancedExportSettings("username", "pass", "url1", "url2", "url3");
    }

}
