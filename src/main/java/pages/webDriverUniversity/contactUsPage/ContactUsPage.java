package pages.webDriverUniversity.contactUsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import setupAndUtilitys.util.FunctionsPage;

import java.util.HashMap;

public class ContactUsPage extends FunctionsPage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
        initMap();
    }

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, LocatorAndTranslation> mapOfPageElements = new HashMap<>();

    private void initMap() {
        mapOfPageElements.put("commentsBox", new LocatorAndTranslation(By.xpath("//textarea[@placeholder='Comments']")));
    }

    public void checkAllElements() {
        checkIfPageContainsAllElementsWithTranslation(mapOfPageElements, softAssert);
    }

    public void inputAlertMessageIntoCommentBox(String message) {
        inputText(mapOfPageElements.get("commentsBox").getLocator(), message, "commentsBox");
    }

}
