package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjectModules.LoginPage;
import utilities.ContextConfiguration;

public class LoginStepDefinition {
    public LoginPage loginPage;
    ContextConfiguration contextConfiguration;

    public LoginStepDefinition(ContextConfiguration contextConfiguration) {
        this.contextConfiguration = contextConfiguration;
        this.loginPage = new LoginPage(this.contextConfiguration.driver);
    }

    @Given("admin is on login page")
    public void admin_is_on_login_page() {
        Assert.assertTrue(loginPage.pageTitle().contains("OrangeHRM"));
    }

    @When("admin inputs credentials {string} and password: {string}")
    public void admin_inputs_credentials(String username, String password) {
        loginPage.loggingIn(username,password);
    }

    @Then("OrangeHRM Dashboard homepage is confirmed")
    public void OrangeHRM_Dashboard_homepage_is_confirmed() {
        loginPage.correctLogin();
    }

    @Then("invalid credentials message is show")
    public void invalid_credentials_message_is_show() {
        loginPage.assertingCredentials();
    }

    @Then("not credentials message is show")
    public void not_credentials_message_is_show() {
        loginPage.assertingNotEmpty();
    }
}
