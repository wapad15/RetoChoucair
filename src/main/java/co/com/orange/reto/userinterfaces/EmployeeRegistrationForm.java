package co.com.orange.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmployeeRegistrationForm {
    public static final Target FIRST_NAME = Target.the("First Name field")
            .located(By.name("firstName"));

    public static final Target MIDDLE_NAME = Target.the("Middle Name field")
            .located(By.name("middleName"));
    public static final Target LAST_NAME = Target.the("Last Name field")
            .located(By.name("lastName"));

    public static final Target EMPLOYEE_ID = Target.the("Employee ID field")
            .located(By.xpath("//label[contains(text(),'Employee Id')]/ancestor::div[contains(@class,'oxd-input-group')]//input"));

    public static final Target CREATE_LOGIN_DETAILS = Target.the("Create Login Details switch")
            .located(By.xpath("//div[contains(@class,'oxd-switch-wrapper')]//span[contains(@class, 'oxd-switch-input')]"));


    public static final Target USERNAME = Target.the("Username field")
            .located(By.xpath("//label[contains(text(),'Username')]/ancestor::div[contains(@class,'oxd-input-group')]//input"));

    public static final Target PASSWORD = Target.the("Password field")
            .located(By.xpath("//label[contains(text(),'Password')]/ancestor::div[contains(@class,'oxd-input-group')]//input"));

    public static final Target CONFIRM_PASSWORD = Target.the("Confirm Password field")
            .located(By.xpath("//label[contains(text(),'Confirm Password')]/ancestor::div[contains(@class,'oxd-input-group')]//input"));




}
