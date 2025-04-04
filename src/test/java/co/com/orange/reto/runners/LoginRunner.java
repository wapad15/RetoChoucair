package co.com.orange.reto.runners;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = "co.com.orange.reto.stepdefinitions",
        tags = "@reto",
        snippets = SnippetType.CAMELCASE
)

public class LoginRunner {
}
