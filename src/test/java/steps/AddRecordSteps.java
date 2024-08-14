package steps;

import common.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class AddRecordSteps {
    PageManager pageManager = new PageManager();

    @Given("I navigate to the {string} page in Add Record")
    public void i_navigate_to_the_page_in_add_record(String page) {
        pageManager.addRPage.open();
    }

    @When("I click the Add button")
    public void iClickTheAddButton() {
        pageManager.addRPage.clickAddButton();
    }

    @Then("I should see the Registration Form displayed")
    public void iShouldSeeTheRegistrationFormDisplayed() {
        assertThat(pageManager.addRPage.isRegistrationFormDisplayed()).isTrue();
    }

    @When("I enter first name {string} and last name {string}")
    public void iEnterFirstNameAndLastName(String firstName, String lastName) {
        pageManager.addRPage.enterFirstName(firstName);
        pageManager.addRPage.enterLastName(lastName);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        pageManager.addRPage.enterEmail(email);
    }

    @When("I enter age {string}")
    public void iEnterAge(String age) {
        pageManager.addRPage.enterAge(age);
    }

    @When("I enter salary {string}")
    public void iEnterSalary(String salary) {
        pageManager.addRPage.enterSalary(salary);
    }

    @When("I enter department {string}")
    public void iEnterDepartment(String department) {
        pageManager.addRPage.enterDepartment(department);
    }

    @When("I submit the record")
    public void iSubmitTheRecord() {
        pageManager.addRPage.clickSubmitButton();
    }

    @Then("I should see the new record with first name {string} and last name {string} in the table")
    public void iShouldSeeTheRecordInTable(String firstName, String lastName) {
        String addedFirstName = pageManager.addRPage.getAddFirstName(firstName, lastName);
        String addedLastName = pageManager.addRPage.getAddedLastName(firstName, lastName);
        assertThat(addedFirstName).isEqualTo(firstName);
        assertThat(addedLastName).isEqualTo(lastName);
    }

    @When("I click the Edit button for the recently added record")
    public void iClickTheEditButtonForRecentlyAddedRecord() {
        pageManager.addRPage.clickEditButtonForRecord("Sena", "Efe");
    }

    @Then("I should see the Registration Form displayed with the record's details")
    public void iShouldSeeTheRegistrationFormDisplayedWithRecordDetails() {
        assertThat(pageManager.addRPage.isRegistrationFormDisplayed()).isTrue();
    }

    @When("I update first name to {string}")
    public void iUpdateFirstName(String newFirstName) {
        pageManager.addRPage.enterFirstName(newFirstName);
    }

    @Then("I should see the updated record with first name {string} and last name {string} in the table")
    public void iShouldSeeTheRecordUpdated(String updatedFirstName, String lastName) {
        String addedFirstName = pageManager.addRPage.getAddFirstName(updatedFirstName, lastName);
        String addedLastName = pageManager.addRPage.getAddedLastName(updatedFirstName, lastName);
        assertThat(addedFirstName).isEqualTo(updatedFirstName);
        assertThat(addedLastName).isEqualTo(lastName);
    }
}
