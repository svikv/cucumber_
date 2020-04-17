package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
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

    public Login() {
        driver = DriverBuilder.driver;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        general = new General();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Given("^user is on the login page$")
    public void I_am_on_the_home_page() {
        driver.navigate().to(Page.getPageUrl());
    }

    @When("^user login with valid login$")
    public void user_login_with_valid_login() {

        String user = Page.getAuthUser().get("authUser");
        String password = Page.getAuthUser().get("authPass");
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

}