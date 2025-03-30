package co.com.orange.reto.tasks;

import co.com.orange.reto.userinterfaces.DashboardPage;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;



import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ClickOn implements Task {
    private final String buttonName;

    public ClickOn(String button) {
        this.buttonName = button;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        Target button = DashboardPage.BUTTONS.get(buttonName.toUpperCase());

        if (button != null) {
          actor.attemptsTo(Click.on(button));
        } else {
            throw new IllegalArgumentException("Button not recognized: " + buttonName);
        }
    }

    public static ClickOn on(String button) {
        return instrumented(ClickOn.class, button);
    }
}
