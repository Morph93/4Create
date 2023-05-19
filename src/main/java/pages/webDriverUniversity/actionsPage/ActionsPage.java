package pages.webDriverUniversity.actionsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import setupAndUtilitys.util.FunctionsPage;

import java.io.IOException;
import java.util.HashMap;

public class ActionsPage extends FunctionsPage {
    public ActionsPage(WebDriver driver) {
        super(driver);
        initMap();
    }

    public static String alertMessage;

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, LocatorAndTranslation> mapOfPageElements = new HashMap<>();

    private void initMap() {
        mapOfPageElements.put("draggableBox", new LocatorAndTranslation(By.xpath("//div[@id='draggable']")));
        mapOfPageElements.put("destinationBox", new LocatorAndTranslation(By.xpath("//div[@id='droppable']")));
        mapOfPageElements.put("hoverFirstElement", new LocatorAndTranslation(By.xpath("//button[normalize-space()='Hover Over Me First!']")));
    }

    public void checkAllElements() {
        checkIfPageContainsAllElementsWithTranslation(mapOfPageElements, softAssert);
    }

    public void validatePageTitle() {
        if (!getPageTitle().equals("WebDriver | Actions")) {
            Assert.fail("Page title is incorrect, it's: " + getPageTitle());
        }
    }

    public void dragAndDropBox() {
        dragAndDrop(waitIsPresent(mapOfPageElements.get("draggableBox").getLocator())
                , waitIsPresent(mapOfPageElements.get("destinationBox").getLocator()));
    }

    public void checkIfLink1IsDisplayedBeforeHover() {
        if (waitIsPresent(By.xpath("//div[@class='dropdown hover']//a[@class='list-alert'][normalize-space()='Link 1']")).isDisplayed()) {
            Assert.fail("Link 1 is displayed before hover over the element.");
        }
    }

    public void hoverOverFirstHoverElement() {
        hoverElement(waitIsPresent(mapOfPageElements.get("hoverFirstElement").getLocator()));
    }

    public void checkIfLink1IsDisplayedAfterHover() {
        if (!waitIsPresent(By.xpath("//div[@class='dropdown hover']//a[@class='list-alert'][normalize-space()='Link 1']")).isDisplayed()) {
            Assert.fail("Link 1 is not displayed after hover over the element.");
        }
    }

    public void clickOnLinkThatAppeared() {
        clickElementXpath(By.xpath("//div[@class='dropdown hover']//a[@class='list-alert'][normalize-space()='Link 1']"), "firstHoverLink");
    }

    public void storeAlertMessage(){
        alertMessage = getAlertMessage();
        clickOKOnAlert();
    }

    public void closeEveryTab(){
        closeAllTabs();
    }
}
