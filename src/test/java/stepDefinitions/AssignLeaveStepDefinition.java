package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModules.LoginPage;
import pageObjectModules.AssignLeavePage;
import utilities.AssignLeave;
import utilities.ContextConfiguration;

public class AssignLeaveStepDefinition {
    AssignLeavePage assignLeavePage;
    LoginPage loginPage;
    ContextConfiguration contextConfiguration;

    public AssignLeaveStepDefinition(ContextConfiguration contextConfiguration){
        this.contextConfiguration = contextConfiguration;
        this.assignLeavePage = new AssignLeavePage(this.contextConfiguration.driver);
        this.loginPage = new LoginPage(this.contextConfiguration.driver);
    }

    @Given("admin is on assign leave page")
    public void admin_is_on_assign_leave_page() {
        loginPage.loggingIn("Admin", "admin123");
        assignLeavePage.accessLeavePage();
    }

    @When("admin inputs all employee information")
    public void admin_inputs_all_employee_information() {
        AssignLeave assignLeave = new AssignLeave();
        assignLeavePage.enterInfo(assignLeave);
    }

    @And("admin creates employee leave")
    public void adminCreatesEmployeeLeave() throws InterruptedException{
        assignLeavePage.clickAssignButton();
    }

    @Then("employee leave is confirmed")
    public void employee_leave_is_confirmed() {
        assignLeavePage.confirmLeave();
    }
}
