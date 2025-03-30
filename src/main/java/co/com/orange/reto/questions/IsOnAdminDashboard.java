package co.com.orange.reto.questions;

import co.com.orange.reto.userinterfaces.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class IsOnAdminDashboard implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(DashboardPage.DASHBOARD_HEADER).answeredBy(actor).equals("Dashboard");
    }

    public static Question<Boolean> isVisible() {
        return new IsOnAdminDashboard();
    }
}
