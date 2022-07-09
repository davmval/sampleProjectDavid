package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModules.LeaveListPage;
import pageObjectModules.LoginPage;
import utilities.AssignLeave;
import utilities.ContextConfiguration;

public class LeaveListStepDefinition {
    LeaveListPage leaveListPage;
    LoginPage loginPage;
    ContextConfiguration contextConfiguration;
    AssignLeave AssignLeave;

    public LeaveListStepDefinition(ContextConfiguration contextConfiguration){
        this.contextConfiguration = contextConfiguration;
        this.leaveListPage = new LeaveListPage(this.contextConfiguration.driver);
        this.loginPage = new LoginPage(this.contextConfiguration.driver);
    }

    @Given("admin is on leave list page")
    public void admin_is_on_leave_list_page() {
        loginPage.loggingIn("Admin", "admin123");
        leaveListPage.leaveListPage();
    }

    @When("admin searches for employee leave")
    public void admin_searches_for_employee_leave(){
        leaveListPage.clickSearchButton();
    }

    @When("admin applies the cancel action")
    public void admin_Applies_The_Cancel_Action() {
        leaveListPage.clickResetButton();
    }

    @And("search all parameter is checked")
    public void search_all_parameter_is_checked() {
        leaveListPage.clickCheckboxAll();
    }

    @Then("the leave can be viewed")
    public void the_leave_can_be_viewed() {
        AssignLeave = new AssignLeave("");
        leaveListPage.confirmNameDisplayed();
    }

    @Then("the employee leave is now canceled")
    public void the_Employee_Leave_Is_Now_Canceled() {
        leaveListPage.clickSaveButton();
    }
}