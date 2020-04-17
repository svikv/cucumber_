package steps;

import Selenium.SeleniumFunctions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class GithubLoginSD {

    SeleniumFunctions sf = new SeleniumFunctions();

    @Given("^user is on github homepage$")
    public void user_is_on_github_homepage() throws MalformedURLException,
            InterruptedException {
//        sf.createDriver();
        sf.isHomePageDisplayed();
    }

    @Given("^пользователь находится на Домашней странице$")
    public void ru_user_is_on_github_homepage() {
        sf.isHomePageDisplayed();
    }

    @Given("^user Fail is on github homepage$")
    public void user_fail_is_on_github_homepage() throws MalformedURLException,
            InterruptedException {

        Assert.fail("Test fail");
    }

    @When("^user input (.*) login to the login field$")
    public void user_input_login(String login) {
        sf.inputLogin(login);
    }

    @When("^user input (.*) password to the login field$")
    public void user_input_password(String password) {
        sf.inputPassword(password);
    }

    @When("^user clicks on Sign in button$")
    public void user_clicks_on_Sign_in_button() {
        sf.clickSigninLink();
    }

    @When("^user login to site$")
    public void user_login_to_site(DataTable arg) {
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        sf.loginToSite(table.get(0).get("Login"), table.get(0).get("Password"));
    }

    @Когда("^пользователь нажимает на кнопку 'Вход'$")
    public void ru_user_clicks_on_Sign_in_button() {
        sf.clickSigninLink();
    }



//    @Then("^user is displayed login screen$")
//    public void user_is_displayed_login_screen() {
//        Assert.assertTrue("Something wrong", sf.isLoginSectionDisplayed());
//        sf.teardown();
//    }

    @Тогда("^пользователь видит Логин страницу$")
    public void ru_user_is_displayed_login_screen() {
        sf.isLoginSectionDisplayed();

    }


}
