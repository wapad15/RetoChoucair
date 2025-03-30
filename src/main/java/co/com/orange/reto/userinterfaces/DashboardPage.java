package co.com.orange.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.Map;

public class DashboardPage {
    public static final Target DASHBOARD_HEADER = Target.the("Dashboard header")
            .located(By.xpath("//h6[text()='Dashboard']"));

    public static final Target PIM_SECTION = Target.the("PIM Section")
            .locatedBy("//a[contains(@href, '/web/index.php/pim/viewPimModule')]");

    public static final Target ADD_BUTTON = Target.the("Add button")
            .locatedBy("//button[contains(., 'Add')]");

    public static final Target SAVE_BUTTON = Target.the("Save button")
            .locatedBy("//button[contains(., 'Save')]");

    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.xpath("//button[contains(@class, 'oxd-button--secondary') and contains(., 'Search')]"));

    public static final Target EMPLOYEE_ID_IN_RESULTS = Target.the("Employee ID in results")
            .locatedBy("//div[contains(@class,'oxd-table-card')]//div[contains(@class,'oxd-table-cell')][2]//div[normalize-space(.)='{0}']");

    public static final Map<String, Target> BUTTONS = Map.of(
            "PIM", PIM_SECTION,
            "DASHBOARD_HEADER", DASHBOARD_HEADER,
            "ADD", ADD_BUTTON,
            "SAVE", SAVE_BUTTON,
            "SEARCH",SEARCH_BUTTON,
            "EMPLOYEE_ID_IN_RESULTS",EMPLOYEE_ID_IN_RESULTS
    );

}
