package pages.rahulsAcademy.chooseCountry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.rahulsAcademy.thankYouPage.ThankYouPage;
import setupAndUtilitys.driverFactory.DriverFactory;
import setupAndUtilitys.util.FunctionsPage;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ChooseCountryPage extends FunctionsPage {

    public ChooseCountryPage(WebDriver driver, String state) {
        super(driver);
        initMap(state);
    }

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, LocatorAndTranslation> mapOfPageElements = new HashMap<>();

    private void initMap(String state) {
        switch (state) {
            case "default":
                mapOfPageElements.put("countryDropdown", new LocatorAndTranslation(By.xpath("//select")));
                mapOfPageElements.put("tacCheckbox", new LocatorAndTranslation(By.xpath("//input[@type='checkbox']")));
                mapOfPageElements.put("proceedButton", new LocatorAndTranslation(By.xpath("//button[normalize-space()='Proceed']")));
                break;
            default:
                break;
        }
    }

    public void checkAllElements() {
        checkIfPageContainsAllElementsWithTranslation(mapOfPageElements, softAssert);
    }

    public void openCountryList() {
        clickElementXpath(mapOfPageElements.get("countryDropdown").getLocator(), "countryDropdown");
    }

    public void validateThatSelectIsDisabled() {
        WebElement select = waitIsPresent(By.xpath("//option[normalize-space()='Select']"));
        if (select.isEnabled()) {
            Assert.fail("Select should be disabled but it isn't.");
        }
    }

    public void chooseRandomCountry() {
        Random random = new Random();
        int randomCountryNumber;

        List<WebElement> countryList = waitListIsPresent(By.xpath("//option"));
        countryList.remove(0);
        randomCountryNumber = random.nextInt(countryList.size());

        WebElement country = countryList.get(randomCountryNumber);
        country.click();
    }

    public void acceptTAC() {
        clickElementXpath(mapOfPageElements.get("tacCheckbox").getLocator(), "tacCheckbox");
    }

    public ThankYouPage proceedWithOrder() {
        clickElementXpath(mapOfPageElements.get("proceedButton").getLocator(), "proceedButton");
        return new ThankYouPage(DriverFactory.getDriver(),"default");
    }


}
