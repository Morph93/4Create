package parallel.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.rahulsAcademy.checkout.CheckoutPage;
import pages.rahulsAcademy.chooseCountry.ChooseCountryPage;
import pages.rahulsAcademy.thankYouPage.ThankYouPage;
import pages.webDriverUniversity.actionsPage.ActionsPage;
import pages.webDriverUniversity.contactUsPage.ContactUsPage;
import pages.webDriverUniversity.homePage.HomePage;
import setupAndUtilitys.driverFactory.DriverFactory;
import io.cucumber.java.en.When;
import pages.rahulsAcademy.dashboard.DashboardPage;

import java.io.IOException;

import static pages.webDriverUniversity.actionsPage.ActionsPage.alertMessage;
import static setupAndUtilitys.util.FunctionsPage.openBrowserAgainAndGoToSpecificPage;

public class Steps {
    DashboardPage dashboardPage;
    CheckoutPage checkoutPage;
    ChooseCountryPage chooseCountryPage;
    ThankYouPage thankYouPage;
    HomePage homePage;
    ActionsPage actionsPage;
    ContactUsPage contactUsPage;

    @Then("All elements should be present on home page")
    public void allElementsShouldBePresentOnHomePage() {
        dashboardPage = new DashboardPage(DriverFactory.getDriver(), "firstCase");
        dashboardPage.checkAllElements();

    }


    @When("I add {int} item {int} times in the basket")
    public void iAddItemTimesInTheBasket(int noItems, int noTimes) {
        dashboardPage = new DashboardPage(DriverFactory.getDriver(), "firstCase");
        dashboardPage.addItemToTheBasket(noItems, noTimes);
    }

    @Then("Validate number of items that are added")
    public void validateNumberOfItemsThatAreAdded() {
        dashboardPage.validateNumberOfAddedItems();
    }

    @When("I add the cheapest, most expensive and random item to the basket")
    public void iAddTheCheapestMostExpensiveAndRandomItemToTheBasket() {
        dashboardPage = new DashboardPage(DriverFactory.getDriver(), "firstCase");
        dashboardPage.addMostExpensiveCheapestAndRandomGroceryToTheBasket();
    }

    @And("Proceed to checkout")
    public void proceedToCheckout() {
        dashboardPage.clickOnCart();
        checkoutPage = dashboardPage.clickOnProceedToCheckout();
    }

    @And("Enter promo code that's totalAmount")
    public void enterPromoCodeThatSTotalAmount() {
        checkoutPage.enterPromoCodeAndUseTotalAmount();
    }

    @Then("Verify if the error message is displayed")
    public void verifyIfTheErrorMessageIsDisplayed() {
        checkoutPage.validateIfTheErrorMessageIsDisplayedForInvalidPromoCode();
    }

    @And("Click to place the order")
    public void clickToPlaceTheOrder() {
        chooseCountryPage = checkoutPage.clickPlaceOrder();
    }

    @Then("User should be redirected to Choose country page")
    public void userShouldBeRedirectedToChooseCountryPage() {
        chooseCountryPage.checkAllElements();
    }

    @And("Open country list")
    public void openCountryList() {
        chooseCountryPage.openCountryList();
    }

    @Then("Validate that the Select is disabled")
    public void validateThatTheSelectIsDisabled() {
        chooseCountryPage.validateThatSelectIsDisabled();
    }

    @And("Choose random country from the list")
    public void chooseRandomCountryFromTheList() {
        chooseCountryPage.chooseRandomCountry();
    }

    @And("Accept tac and proceed with order")
    public void acceptTacAndProceedWithOrder() {
        chooseCountryPage.acceptTAC();
        thankYouPage = chooseCountryPage.proceedWithOrder();
    }

    @Then("User should be presented with order confirmation message")
    public void userShouldBePresentedWithOrderConfirmationMessage() {
        thankYouPage.checkMessage();
    }

    @And("Go to webDriverUniversity page")
    public void goToWebDriverUniversityPage() {
        homePage = new HomePage(DriverFactory.getDriver());
        homePage.openHomePage();
    }

    @And("Scroll to the Actions section")
    public void scrollToTheActionsSection() {
        homePage.scrollToActions();
    }

    @And("Take a screenshot")
    public void takeAScreenshot() throws IOException {
        new HomePage(DriverFactory.getDriver()).takeScreenShotOfActionsSection();
    }

    @And("Click on Actions")
    public void clickOnActions() {
        actionsPage = homePage.clickOnActions();
    }

    @Then("User should be redirected to Actions page")
    public void userShouldBeRedirectedToActionsPage() {
        actionsPage.validatePageTitle();
    }

    @And("Go back to Homepage tab")
    public void goBackToHomepageTab() {
        actionsPage.switchTabs(1);
    }

    @And("Go back to third tab Actions")
    public void goBackToThirdTabActions() {
        actionsPage.switchTabs(2);
    }

    @Then("Drag and drop target box")
    public void dragAndDropTargetBox() {
        actionsPage.dragAndDropBox();
    }

    @Then("Validate that Link isn't shown until mouse is hovered on it")
    public void validateThatLinkIsnTShownUntilMouseIsHoveredOnIt() {
        actionsPage.checkIfLink1IsDisplayedBeforeHover();
    }

    @And("Hover over first hover element")
    public void hoverOverFirstHoverElement() {
        actionsPage.hoverOverFirstHoverElement();
    }

    @Then("Validate that Link is shown after mouse is hovered on it")
    public void validateThatLinkIsShownAfterMouseIsHoveredOnIt() {
        actionsPage.checkIfLink1IsDisplayedAfterHover();
    }

    @And("Click on link that appears after hover")
    public void clickOnLinkThatAppearsAfterHover() {
        actionsPage.clickOnLinkThatAppeared();
    }

    @And("Save alert message and click OK")
    public void saveAlertMessageAndClickOK() {
        actionsPage.storeAlertMessage();
    }

    @And("Close browser")
    public void closeBrowser() {
        actionsPage.closeEveryTab();
    }

    @And("Open browser again and go to contact us page")
    public void openBrowserAgainAndGoToContactUsPage() {
        openBrowserAgainAndGoToSpecificPage("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @Then("Input saved alert message into comment text box")
    public void inputSavedAlertMessageIntoCommentTextBox() {
        contactUsPage = new ContactUsPage(DriverFactory.getDriver());
        contactUsPage.inputAlertMessageIntoCommentBox(alertMessage);
    }

}
