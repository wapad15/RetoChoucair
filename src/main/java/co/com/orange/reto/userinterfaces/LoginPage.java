package co.com.orange.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME_FIELD = Target.the("Username field")
            .located(By.name("username"));

    public static final Target PASSWORD_FIELD = Target.the("Password field")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.xpath("//button[@type='submit']"));

    public static final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
}
