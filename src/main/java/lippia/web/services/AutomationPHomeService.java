package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.AutomationPracticeConstants;
import org.openqa.selenium.Keys;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class AutomationPHomeService extends ActionManager {

    public static void navegarWeb(){
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void clickButton(){
        click(AutomationPracticeConstants.BUTTON_SIGNIN_XPATH);
    }

    public static void realizarBusqueda(String keyword) {
        click(AutomationPracticeConstants.INPUT_SEARCH_XPATH);
        setInput(AutomationPracticeConstants.INPUT_SEARCH_XPATH,keyword + Keys.ENTER);

    }
}
