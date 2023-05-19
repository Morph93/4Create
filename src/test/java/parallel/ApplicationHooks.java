package parallel;

import setupAndUtilitys.driverFactory.DriverFactory;
import setupAndUtilitys.util.Resources;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ApplicationHooks implements ConcurrentEventListener {


    private WebDriver driver;

    public ApplicationHooks() {
    }


    /**
     * @runId -> This is the ID of the specific run inside the TestRail in which you want to add results of testing.
     * It should be changed every time you create new run in TestRail.
     * @FAIL_STATE -> It's from the documentation how to set the state of the test case to FAILED.
     * @SUCCESS_STATE -> It's from the documentation how to set the state of the test case to PASS.
     * @SUCCESS_COMMENT -> Which comment you wish to add to your test case when it's in PASS state.
     * @FAILED_COMMENT -> Which comment you wish to add to your test case when it's in FAILED state.
     * This is just first part of the comment, we are adding additional string based on the fail reason.
     * @caseId -> This is the test case ID from the TestRail, and it has to be unique. It's connected via Cucumber feature file
     * from where we read it.
     * @errMsgList -> This will catch multiple errors in case we are doing softAssert.
     */

    private static String runId = "1";
    private static final int FAIL_STATE = 5;
    private static final int SUCCESS_STATE = 1;
    private static final String SUCCESS_COMMENT = "This test passed with Selenium";
    private static final String FAILED_COMMENT = "This automated test failed due to following reasons: ";
    public static String caseId;
    public static String scenarioName;

    @Rule
    public TestName testName = new TestName();

    /**
     * @browserName -> We're getting it from Resources Enum class.
     * @url -> We're reading from configuration property file and setting desired URL address.
     */
    @Before(order = 0, value = "@UI")
    public void launchBrowser() {
        DriverFactory driverFactory = new DriverFactory();
        String browserName = Resources.browser.getResource();
        driver = driverFactory.init_driver(browserName);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }


    /**
     * The order 0 will call quit on driver and close the browser.
     */
    @After(order = 0, value = "@UI")
    public void quitBrowser() {
        driver.quit();
    }

    /**
     * @param scenario is used to extract scenarioName.
     *                 scenarioName is used to set the name of the screenshot.
     *                 <p>
     *                 We are also checking if scenario is passed and if the condition is true we remove recording.
     */
    @After(order = 1, value = "@UI")
    public void tearDown(Scenario scenario) throws Exception {

        //if (scenario.isFailed() && scenario.) { ToDo -> Uncomment if you want scs only on failed
        // take screenshot:
        scenarioName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", scenarioName);
        //}

    }



    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        // eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onTestFail);
    }
}
