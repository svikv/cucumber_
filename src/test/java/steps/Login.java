package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import utilities.DriverBuilder;

import java.util.List;
import java.util.Map;

public class Login {

    private Logger LOG = Logger.getLogger(getClass());
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private General general;
    private String user;
    private String password;

    public Login() {
        driver = DriverBuilder.driver;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        general = new General();
        homePage = PageFactory.initElements(driver, HomePage.class);
        user = Page.getAuthUser().get("authUser");
        password = Page.getAuthUser().get("authPass");
    }

    @Given("^user is on the login page$")
    public void I_am_on_the_home_page() {
        driver.navigate().to(Page.getPageUrl());
    }

    @When("^user login with valid login$")
    public void user_login_with_valid_login() {
        loginPage.loginToPage(user, password);
    }

    @Then("^avatar should be on login screen$")
    public void avatar_should_be_on_login_screen() {
        general.checkExpectedResult("Avatar isn't displayed", homePage.isAvatarDisplayed());
    }

    @When("^user login with wrong login$")
    public void user_login_with_wrong_login(DataTable arg) {
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        loginPage.loginToPage(table.get(0).get("Login"), table.get(0).get("Password"));
    }

    @Then("^loginBox should be on login screen$")
    public void loginBox_should_be_on_login_screen() {
    }


//    @Then("^user is displayed login screen$")
//    public void user_is_displayed_login_screen() {
//        Assert.assertTrue("Something wrong", sf.isLoginSectionDisplayed());
//        sf.teardown();
//    }

//    @When("^user login to site$")
//    public void user_login_to_site(DataTable arg) {
//        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
//        sf.loginToSite(table.get(0).get("Login"), table.get(0).get("Password"));
//    }

}