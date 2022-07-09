package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModules.LoginPage;
import pageObjectModules.MyInfoPage;
import utilities.ContextConfiguration;
import utilities.MyInfo;

public class MyInfoStepDefinition {
    MyInfo myInfo;
    MyInfoPage myInfoPage;
    LoginPage loginPage;
    ContextConfiguration contextConfiguration;

    public MyInfoStepDefinition(ContextConfiguration contextConfiguration){
        this.contextConfiguration = contextConfiguration;
        this.myInfoPage = new MyInfoPage(this.contextConfiguration.driver);
        this.loginPage = new LoginPage(this.contextConfiguration.driver);
    }

    @Given("admin is on My Info tab")
    public void admin_is_on_My_Info_tab() {
        loginPage.loggingIn("Admin", "admin123");
        myInfoPage.clickMyInfoTab();
    }

    @When("admin edits details")
    public void admin_edits_details() {
        myInfo = new MyInfo();
        myInfoPage.editButton();
        myInfoPage.enterInfoDetails(myInfo);
    }

    @When("admin adds a new language")
    public void admin_Adds_A_New_Language() {
        myInfoPage.clickDropdownLanguage();
        myInfoPage.clickDropdownFluency();
        myInfoPage.clickDropdownCompetency();
    }

    @When("admin enters new immigration details")
    public void admin_enters_new_immigration_details() {
        myInfo = new MyInfo();
        myInfoPage.inputImmaDetails(myInfo);
    }

    @And("admin is on Contact details subsection")
    public void admin_is_on_Contact_details_subsection() {
        myInfoPage.clickDetails();
    }

    @And("admin is on Immigration subsection")
    public void admin_is_on_Immigration_subsection() {
        myInfoPage.clickImmaSection();
    }

    @And("admin is on Qualifications subsection")
    public void admin_Is_On_Qualifications_Subsection() {
        myInfoPage.clickQualifySection();
    }

    @Then("saves the edited details")
    public void saves_the_edited_details() {
        myInfoPage.clickSaveButton();
    }

    @Then("the immigration details can be viewed")
    public void the_immigration_details_can_be_viewed() {
        myInfoPage.clickSaveButton();
    }

    @Then("the language profile is updated")
    public void the_language_Profile_Is_Updated() {
        myInfoPage.clickSaveLanguageButton();
    }
}
