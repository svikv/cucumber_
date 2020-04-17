package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.Page;
import utilities.DriverBuilder;
import utilities.Utils;

import java.util.concurrent.TimeUnit;

public class General {

    private Logger LOG = Logger.getLogger(getClass());
    private DriverBuilder driverBuilder = new DriverBuilder();
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;
    private Utils utils;
    private String pathToScreenShot;

    public General() {
        driver = DriverBuilder.driver;
//        loginPage = PageFactory.initElements(driver, LoginPage.class);
//        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp(Scenario scenario) throws Exception {
        System.out.println( "--------- Scenario "  + scenario.getName() + " started -------- \n ");

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
        System.out.println( "--------- Scenario "  + scenario.getName() + " finished -------- \n ");
    }

    protected  void checkExpectedResult(String message, boolean actualResult) {

        if (!actualResult) {
            utils.captureScreenshot(pathToScreenShot, driver);
        }

        Assert.assertTrue(message, actualResult);
    }

    @Given("^user is on the home page$")
    public void user_is_on_the_home_page() {
        driver.navigate().to(Page.getPageUrl());

        String user = Page.getAuthUser().get("authUser");
        String password = Page.getAuthUser().get("authPass");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);

        loginPage.loginToPage(user, password);
        checkExpectedResult("Avatar isn't displayed", homePage.isAvatarDisplayed());
    }
}
