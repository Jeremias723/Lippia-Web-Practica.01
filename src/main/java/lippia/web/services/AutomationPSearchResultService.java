package lippia.web.services;


import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.AutomationPracticeConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.crowdar.core.actions.WebActionManager.*;

public class AutomationPSearchResultService extends ActionManager {

    public static void verificarBusqueda(String pc) {
    waitVisibility(AutomationPracticeConstants.H1_TITULO_BUSQUEDA_XPATH);
    Assert.assertTrue(getText(AutomationPracticeConstants.H1_TITULO_BUSQUEDA_XPATH).contains(pc.toUpperCase()),"No se encontro la palabra dentro del sitio");
    }

    public static void verificarLogIn(String usserName) {
        System.out.println(usserName);
        Assert.assertEquals(getText(AutomationPracticeConstants.A_USSERNAME_XPATH),usserName,"No se encuentra el usuario");
    }

    public static void ordenarProductos(String order) {

       Select orderSelect = new Select(getElement(AutomationPracticeConstants.SELECT_ORNERPRODUCTS_XPATH));
       orderSelect.selectByVisibleText(order);

    }

    public static void verificarOrdenDeProductos() {
        int catnP= Integer.parseInt(getText(AutomationPracticeConstants.SPAN_CANTPRODUCTS_XPATH).substring(0,1));
        System.out.println("Cantidad de productos: " + catnP);
        List<WebElement> elements = getElements(AutomationPracticeConstants.SPAN_PRODUCTPRICE_XPATH);
        List<Double> price = new ArrayList<>();
        for (int i = 0; i < catnP; i++) {
            String str = elements.get(i).getText().substring(1);
            double aux = Double.parseDouble(str);
            price.add(i,aux);
            System.out.println("Item " + i + ": $" +aux);
        }

        System.out.println("-------Validación------");
        for (int i = 0; i < catnP-1; i++) {
            System.out.println(price.get(i));
            Assert.assertTrue(price.get(i)<price.get(i+1),"Los elementos no se encuentran en el orden indicado");
        }
    }
}
