package co.com.orange.reto.questions;

import co.com.orange.reto.userinterfaces.DashboardPage;
import co.com.orange.reto.userinterfaces.EmployeeRegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyEmployeeExists implements Question<Boolean> {

    public static VerifyEmployeeExists inTheSystem() {
        return new VerifyEmployeeExists();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String employeeId = actor.recall("employeeId");
        actor.attemptsTo(
                Click.on(DashboardPage.PIM_SECTION),
                Enter.theValue(employeeId).into(EmployeeRegistrationForm.EMPLOYEE_ID),
                Click.on(DashboardPage.SEARCH_BUTTON),
                WaitUntil.the(DashboardPage.EMPLOYEE_ID_IN_RESULTS.of(employeeId), isVisible()).forNoMoreThan(3).seconds()
        );
        return DashboardPage.EMPLOYEE_ID_IN_RESULTS
                .of(employeeId)
                .resolveFor(actor)
                .isVisible();
    }
}
