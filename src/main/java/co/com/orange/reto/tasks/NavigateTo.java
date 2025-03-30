package co.com.orange.reto.tasks;

import co.com.orange.reto.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Task theOrangeHRMLoginPage() {
        return Task.where("{0} opens the OrangeHRM login page",
                Open.url(LoginPage.URL)
        );
    }
}
