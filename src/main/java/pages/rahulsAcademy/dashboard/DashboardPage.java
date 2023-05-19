package pages.rahulsAcademy.dashboard;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.rahulsAcademy.checkout.CheckoutPage;
import setupAndUtilitys.driverFactory.DriverFactory;
import setupAndUtilitys.util.FunctionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DashboardPage extends FunctionsPage {

    public DashboardPage(WebDriver driver, String state) {
        super(driver);
        initMap(state);
    }

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, LocatorAndTranslation> mapOfPageElements = new HashMap<>();

    private void initMap(String state) {
        switch (state) {
            case "firstCase":
                mapOfPageElements.put("logo", new LocatorAndTranslation(By.xpath("//div[@class='brand greenLogo']")));
                mapOfPageElements.put("searchInputField", new LocatorAndTranslation(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")));
                mapOfPageElements.put("topDealsLink", new LocatorAndTranslation(By.xpath("//a[normalize-space()='Top Deals']"), "Top Deals"));
                mapOfPageElements.put("flightBookingLink", new LocatorAndTranslation(By.xpath("//a[normalize-space()='Flight Booking']"), "Flight Booking"));
                mapOfPageElements.put("items", new LocatorAndTranslation(By.xpath("//td[normalize-space()='Items']")));
                mapOfPageElements.put("itemsValue", new LocatorAndTranslation(By.xpath("//td[normalize-space()='Items']/following-sibling::td//strong")));
                mapOfPageElements.put("price", new LocatorAndTranslation(By.xpath("//td[normalize-space()='Price']")));
                mapOfPageElements.put("priceValue", new LocatorAndTranslation(By.xpath("//td[normalize-space()='Price']/following-sibling::td//strong")));
                mapOfPageElements.put("cart", new LocatorAndTranslation(By.xpath("//img[@alt='Cart']")));
                mapOfPageElements.put("brocolliGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Brocolli - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("cauliflowerGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Cauliflower - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("cucumberGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Cucumber - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("beetrootGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Beetroot - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("carrotGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Carrot - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("tomatoGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Tomato - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("beansGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Beans - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("brinjalGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Brinjal - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("capsicumGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Capsicum']/ancestor::div[@class='product']")));
                mapOfPageElements.put("mushroomGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Mushroom - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("potatoGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Potato - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("pumpkinGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Pumpkin - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("cornGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Corn - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("onionGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Onion - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("appleGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Apple - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("bananaGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Banana - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("grapesGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Grapes - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("mangoGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Mango - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("mustMelonGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Musk Melon - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("orangeGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Orange - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("pearsGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Pears - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("pomegranateGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Pomegranate - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("raspberryGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Raspberry - 1/4 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("strawberryGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Strawberry - 1/4 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("waterMelonGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Water Melon - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("almondsGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Almonds - 1/4 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("pistaGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Pista - 1/4 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("nutsMixtureGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Nuts Mixture - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("cashewsGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Cashews - 1 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("walnutsGrocery", new LocatorAndTranslation(By.xpath("//h4[normalize-space()='Walnuts - 1/4 Kg']/ancestor::div[@class='product']")));
                mapOfPageElements.put("footer", new LocatorAndTranslation(By.xpath("//footer/p")));

                break;
            case "secondCase":
                mapOfPageElements.put("firstElement", new LocatorAndTranslation(By.xpath("asd"), "asd"));
                mapOfPageElements.put("secondElement", new LocatorAndTranslation(By.xpath("asd"), "asd"));
                break;
            default:
                break;
        }
    }

    public void checkAllElements() {
        checkIfPageContainsAllElementsWithTranslation(mapOfPageElements, softAssert);
    }


    List<String> groceriesGlobal;

    public void addItemToTheBasket(int numberOfItems, int numberOfTimes) {
        groceriesGlobal = mapOfPageElements.keySet().stream()
                .filter(locatorAndTranslation -> locatorAndTranslation.contains("Grocery"))
                .collect(Collectors.toList());

        Random random = new Random();
        int randomGroceryNumber;

        for (int i = 0; i < numberOfItems; i++) {
            randomGroceryNumber = random.nextInt(groceriesGlobal.size());
            for (int j = 1; j < numberOfTimes; j++) {
                clickElementXpath(By.xpath(manipulateElementXpath(mapOfPageElements.get(groceriesGlobal.get(randomGroceryNumber)).getLocator()) + "//a[@class='increment']"), groceriesGlobal.get(randomGroceryNumber));
            }
            clickElementXpath(By.xpath(manipulateElementXpath(mapOfPageElements.get(groceriesGlobal.get(randomGroceryNumber)).getLocator()) + "//button[contains(normalize-space(),'ADD TO CART')]"), groceriesGlobal.get(randomGroceryNumber));
            groceriesGlobal.remove(groceriesGlobal.get(randomGroceryNumber));
        }

    }

    public void addMostExpensiveCheapestAndRandomGroceryToTheBasket() {
        List<String> groceries = mapOfPageElements.keySet().stream()
                .filter(locatorAndTranslation -> locatorAndTranslation.contains("Grocery"))
                .collect(Collectors.toList());

        int highestPrice = 0;
        String highestPriceGrocery = null;
        int lowestPrice;
        String lowestPriceGrocery = null;

        for (String s : groceries) {
            WebElement element = waitIsPresent((By.xpath(manipulateElementXpath(mapOfPageElements.get(s).getLocator()) + "//p[@class='product-price']")));
            if (Integer.parseInt(element.getText()) > highestPrice) {
                highestPrice = Integer.parseInt(element.getText());
                highestPriceGrocery = s;
            }
        }

        lowestPrice = highestPrice;
        for (String grocery : groceries) {
            WebElement element = waitIsPresent((By.xpath(manipulateElementXpath(mapOfPageElements.get(grocery).getLocator()) + "//p[@class='product-price']")));
            if (Integer.parseInt(element.getText()) < lowestPrice) {
                lowestPrice = Integer.parseInt(element.getText());
                lowestPriceGrocery = grocery;
            }
        }


        clickElementXpath(By.xpath(manipulateElementXpath(mapOfPageElements.get(highestPriceGrocery).getLocator()) + "//button[contains(normalize-space(),'ADD TO CART')]"), highestPriceGrocery);
        clickElementXpath(By.xpath(manipulateElementXpath(mapOfPageElements.get(lowestPriceGrocery).getLocator()) + "//button[contains(normalize-space(),'ADD TO CART')]"), lowestPriceGrocery);

        groceries.remove(highestPriceGrocery);
        groceries.remove(lowestPriceGrocery);

        Random random = new Random();
        int randomGroceryNumber;
        randomGroceryNumber = random.nextInt(groceries.size());
        clickElementXpath(By.xpath(manipulateElementXpath(mapOfPageElements.get(groceries.get(randomGroceryNumber)).getLocator()) + "//button[contains(normalize-space(),'ADD TO CART')]"), groceries.get(randomGroceryNumber));

    }


    public void validateNumberOfAddedItems() {
        clickElementXpath(mapOfPageElements.get("cart").getLocator(), "cart");
        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cart-preview active']//p[@class='quantity']"));
        if (cartItems.size() != 4) {
            Assert.fail("Number of added items is incorrect or rng picked same number multiple times");
        }
        if (!cartItems.get(0).getText().contains("4")) {
            softAssert.fail("Number of first item in chart is incorrect, it should be 4, but it's: " + cartItems.get(0).getText());
        }
        if (!cartItems.get(1).getText().contains("1")) {
            softAssert.fail("Number of checkout item in chart is incorrect, it should be 1, but it's: " + cartItems.get(1).getText());
        }
        if (!cartItems.get(2).getText().contains("1")) {
            softAssert.fail("Number of third item in chart is incorrect, it should be 1, but it's: " + cartItems.get(2).getText());
        }
        if (!cartItems.get(3).getText().contains("1")) {
            softAssert.fail("Number of fourth item in chart is incorrect, it should be 1, but it's: " + cartItems.get(3).getText());
        }
        softAssert.assertAll();

    }

    public void clickOnCart() {
        clickElementXpath(mapOfPageElements.get("cart").getLocator(), "cart");
    }

    public CheckoutPage clickOnProceedToCheckout() {
        clickElementXpath(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']"), "proceedToCheckoutButton");
        return new CheckoutPage(DriverFactory.getDriver(),"default");
    }

}
