package steps;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;
import pages.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.DriverBuilder;
import utilities.Utils;

import java.util.concurrent.TimeUnit;

public class General {

    DriverBuilder driver = new DriverBuilder();

    protected WebDriver webDriver;
    protected TransactionPartiesPage transactionParties;
    protected TransactionsPage transactions;
    private Utils utils;
    private String pathToScreenShot;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp(Scenario scenario) throws Exception {
        System.out.println( "--------- Scenario "  + scenario.getName() + " started -------- \n ");

        pathToScreenShot = "../somka/target/screenshot/" + this.getClass().getPackage().getName() +
                "/" + this.getClass().getSimpleName() + this.testName.getMethodName() + ".jpg";

        webDriver = driver.createDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        transactionParties = new TransactionPartiesPage(webDriver);
        transactions = new TransactionsPage(webDriver);
        utils = new Utils();

    }

    @After
    public void afterMethod(Scenario scenario){

        driver.teardown();
        System.out.println( "--------- Scenario "  + scenario.getName() + " finished -------- \n ");

    }

    protected  void checkExpectedResult(String message, boolean actualResult) {

        if (!actualResult) {
            utils.captureScreenshot(pathToScreenShot, webDriver);
        }

        Assert.assertTrue(message, actualResult);
    }


//    @Given("^user is on the login page$")
//    public void I_am_on_the_home_page() {
//        driver.navigate().to(Page.getPageUrl());
//    }

}
