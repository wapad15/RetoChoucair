package co.com.orange.reto.stepdefinitions;

import co.com.orange.reto.models.EmployeeData;
import co.com.orange.reto.questions.IsOnAdminDashboard;
import co.com.orange.reto.questions.VerifyEmployeeExists;
import co.com.orange.reto.tasks.FillEmployeeForm;
import co.com.orange.reto.tasks.Login;
import co.com.orange.reto.tasks.NavigateTo;
import co.com.orange.reto.tasks.ClickOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class loginStepDefinitions {

    @Given("the user is on the OrangeHRM login page")
    public void theUserIsOnTheOrangeHRMLoginPage() {
        OnStage.theActorCalled("user").attemptsTo(NavigateTo.theOrangeHRMLoginPage());
    }
    @And("logs in with valid credentials")
    public void logsInWithValidCredentials() {
        Actor user = theActorInTheSpotlight();
        user.attemptsTo(Login.withCredentials("admin", "admin123"));
    }
    @And("is redirected to the admin dashboard")
    public void isRedirectedToTheAdminDashboard() {
        theActorInTheSpotlight().should(seeThat(IsOnAdminDashboard.isVisible()));
    }
    @Given("the user navigates to the {string} section")
    public void theUserNavigatesToTheSection(String section) {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickOn.on(section));
    }
    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickOn.on(buttonName));
    }
    @When("fills out the employee registration form")
    public void fillsOutTheEmployeeRegistrationForm(DataTable dataTable) {
        EmployeeData employee = EmployeeData.fromDataTable(dataTable).get(0); // Tomamos solo el primer registro
        theActorInTheSpotlight().attemptsTo(
                FillEmployeeForm.withData(employee),
                ClickOn.on("SAVE")
        );
    }

    @Then("the new employee should be successfully added")
    public void theNewEmployeeShouldBeSuccessfullyAdded() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El empleado aparece en los resultados",
                        VerifyEmployeeExists.inTheSystem(),
                        equalTo(true))
        );
    }
    @When("the user searches for the newly added employee")
    public void theUserSearchesForTheNewlyAddedEmployee() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the employee's information should be displayed correctly")
    public void theEmployeeSInformationShouldBeDisplayedCorrectly() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
