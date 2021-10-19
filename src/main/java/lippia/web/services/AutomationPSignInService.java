package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.AutomationPracticeConstants;
import org.testng.Assert;

public class AutomationPSignInService extends ActionManager {

    public static void verificarSignInPage(){
        waitVisibility(AutomationPracticeConstants.INPUT_ADDRESS_XPATH);
        Assert.assertTrue(isVisible(AutomationPracticeConstants.INPUT_ADDRESS_XPATH));
        waitVisibility(AutomationPracticeConstants.H1_TITULO_XPATH);
        Assert.assertEquals(getText(AutomationPracticeConstants.H1_TITULO_XPATH),"AUTHENTICATION","No se encuentra el titulo");
    }

    public static void logIn(String email, String pass) {
        click(AutomationPracticeConstants.INPUT_EMAIL_XPATH);
        setInput(AutomationPracticeConstants.INPUT_EMAIL_XPATH,email);
        click(AutomationPracticeConstants.INPUT_PASSWD_XPATH);
        setInput(AutomationPracticeConstants.INPUT_PASSWD_XPATH,pass);
        click(AutomationPracticeConstants.BUTTON_LOGIN_XPATH);
    }
}
