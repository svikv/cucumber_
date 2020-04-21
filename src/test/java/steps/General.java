package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import utilities.DriverBuilder;
import utilities.Utils;

import java.util.concurrent.TimeUnit;

public class General {

    private Logger LOG = Logger.getLogger(getClass());
    private DriverBuilder driverBuilder = new DriverBuilder();
    private WebDriver driver;
    private Utils utils;
    private String pathToScreenShot;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp(Scenario scenario) throws Exception {
        LOG.info("--------- Scenario "  + scenario.getName() + " started -------- \n ");

        pathToScreenShot = "../somka/target/screenshot/" + this.getClass().getPackage().getName() +
                "/" + this.getClass().getSimpleName() + this.testName.getMethodName() + ".jpg";

        driver = driverBuilder.createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        utils = new Utils();
    }

    @After
    public void afterMethod(Scenario scenario) {
        driverBuilder.teardown();
        LOG.info("--------- Scenario "  + scenario.getName() + " finished -------- \n ");
    }

    protected  void checkExpectedResult(String message, boolean actualResult) {

        if (!actualResult) {
            utils.captureScreenshot(pathToScreenShot, driver);
        }

        Assert.assertTrue(message, actualResult);
    }

}
