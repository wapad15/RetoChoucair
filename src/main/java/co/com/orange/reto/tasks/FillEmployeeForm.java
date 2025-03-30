package co.com.orange.reto.tasks;

import co.com.orange.reto.models.EmployeeData;
import co.com.orange.reto.userinterfaces.EmployeeRegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.util.concurrent.ThreadLocalRandom;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillEmployeeForm implements Task {

    private final EmployeeData employeeData;
    public static String generatedUsername;


    public FillEmployeeForm(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        String employeeId = String.valueOf(ThreadLocalRandom.current().nextInt(10000, 99999));
        String randomSuffix = String.valueOf(ThreadLocalRandom.current().nextInt(100000000, 999999999)); // 9 dígitos
        generatedUsername = employeeData.getUsername() + randomSuffix;
        actor.remember("employeeId", employeeId);

        actor.attemptsTo(
                Enter.theValue(employeeData.getFirstName()).into(EmployeeRegistrationForm.FIRST_NAME),
                Enter.theValue(employeeData.getMiddleName()).into(EmployeeRegistrationForm.MIDDLE_NAME),
                Enter.theValue(employeeData.getLastName()).into(EmployeeRegistrationForm.LAST_NAME),
                Enter.theValue(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE).into(EmployeeRegistrationForm.EMPLOYEE_ID), // Clear
                Enter.theValue(employeeId).into(EmployeeRegistrationForm.EMPLOYEE_ID),
                Click.on(EmployeeRegistrationForm.CREATE_LOGIN_DETAILS), // Marca la casilla
                Enter.theValue(generatedUsername).into(EmployeeRegistrationForm.USERNAME),
                Enter.theValue(employeeData.getPassword()).into(EmployeeRegistrationForm.PASSWORD),
                Enter.theValue(employeeData.getPassword()).into(EmployeeRegistrationForm.CONFIRM_PASSWORD)
                );
    }
    public static FillEmployeeForm withData(EmployeeData employeeData) {
        return instrumented(FillEmployeeForm.class, employeeData);
    }


}
