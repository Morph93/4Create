package pages.rahulsAcademy.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.rahulsAcademy.chooseCountry.ChooseCountryPage;
import setupAndUtilitys.driverFactory.DriverFactory;
import setupAndUtilitys.util.FunctionsPage;

import java.util.HashMap;

public class CheckoutPage extends FunctionsPage {

    public CheckoutPage(WebDriver driver, String state) {
        super(driver);
        initMap(state);
    }

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, LocatorAndTranslation> mapOfPageElements = new HashMap<>();

    private void initMap(String state) {
        switch (state) {
            case "default":
                mapOfPageElements.put("enterPromoCodeInputField", new LocatorAndTranslation(By.xpath("//input[@placeholder='Enter promo code']")));
                mapOfPageElements.put("applyButton", new LocatorAndTranslation(By.xpath("//button[normalize-space()='Apply']")));
                mapOfPageElements.put("totalAmount", new LocatorAndTranslation(By.xpath("//span[@class='totAmt']")));
                mapOfPageElements.put("placeOrder", new LocatorAndTranslation(By.xpath("//button[normalize-space()='Place Order']")));
                break;
            default:
                break;
        }
    }

    public void checkAllElements() {
        checkIfPageContainsAllElementsWithTranslation(mapOfPageElements, softAssert);
    }

    public void enterPromoCodeAndUseTotalAmount() {
        inputText(mapOfPageElements.get("enterPromoCodeInputField").getLocator()
                , waitIsPresent(mapOfPageElements.get("totalAmount").getLocator()).getText()
                , "enterPromoCodeInputField");
        clickElementXpath(mapOfPageElements.get("applyButton").getLocator(), "applyButton");
    }

    public void validateIfTheErrorMessageIsDisplayedForInvalidPromoCode() {
        WebElement errorMessage = waitIsPresent(By.xpath("//span[@class='promoInfo']"));

        if (!errorMessage.getText().equals("Invalid code ..!")) {
            Assert.fail("Error message for invalid promo code is not correct, it's: " + errorMessage.getText());
        }
    }

    public ChooseCountryPage clickPlaceOrder() {
        clickElementXpath(mapOfPageElements.get("placeOrder").getLocator(), "placeOrder");
        return new ChooseCountryPage(DriverFactory.getDriver(), "default");
    }


}
