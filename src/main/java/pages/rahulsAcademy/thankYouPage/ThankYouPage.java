package pages.rahulsAcademy.thankYouPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import setupAndUtilitys.util.FunctionsPage;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ThankYouPage extends FunctionsPage {

    public ThankYouPage(WebDriver driver, String state) {
        super(driver);
        initMap(state);
    }

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, LocatorAndTranslation> mapOfPageElements = new HashMap<>();

    private void initMap(String state) {
        switch (state) {
            case "default":
                mapOfPageElements.put("thankYouMessage", new LocatorAndTranslation(By.xpath("//div[@class='products']//span")));
                break;
            default:
                break;
        }
    }

    public void checkAllElements() {
        checkIfPageContainsAllElementsWithTranslation(mapOfPageElements, softAssert);
    }

    public void checkMessage() {
        if (!waitIsPresent(mapOfPageElements.get("thankYouMessage").getLocator()).getText()
                .equals("Thank you, your order has been placed successfully\n" +
                        "You'll be redirected to Home page shortly!!")) {
            Assert.fail("The thank you message is incorrect.");
        }
    }


}
