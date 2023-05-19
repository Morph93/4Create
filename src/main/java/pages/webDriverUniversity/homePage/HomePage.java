package pages.webDriverUniversity.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.webDriverUniversity.actionsPage.ActionsPage;
import setupAndUtilitys.driverFactory.DriverFactory;
import setupAndUtilitys.util.FunctionsPage;

import java.io.IOException;
import java.util.HashMap;

public class HomePage extends FunctionsPage {
    public HomePage(WebDriver driver) {
        super(driver);
        initMap();
    }

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, LocatorAndTranslation> mapOfPageElements = new HashMap<>();

    private void initMap() {
        mapOfPageElements.put("actionsSection", new LocatorAndTranslation(By.xpath("//h1[normalize-space()='ACTIONS']/ancestor::a")));
    }

    public void checkAllElements() {
        checkIfPageContainsAllElementsWithTranslation(mapOfPageElements, softAssert);
    }

    public void openHomePage() {
        openInNewTab("http://www.webdriveruniversity.com/");
        switchTabs(1);
    }

    public void scrollToActions() {
        scrollToElement(waitIsPresent(mapOfPageElements.get("actionsSection").getLocator()));
    }

    public void takeScreenShotOfActionsSection() throws IOException {
        takeElementScreenshot(waitIsPresent(mapOfPageElements.get("actionsSection").getLocator()), "actionsSection");
    }

    public ActionsPage clickOnActions() {
        clickElementXpath(mapOfPageElements.get("actionsSection").getLocator(), "actionsSection");
        return new ActionsPage(DriverFactory.getDriver());
    }

    public void switchTabsToDesired(int tabNumber) {
        switchTabs(tabNumber);
    }
}
