package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.AutomationPHomeService;
import lippia.web.services.AutomationPSignInService;
import lippia.web.services.AutomationPSearchResultService;

public class AutomationPracticeSteps extends PageSteps {

    @Given("el usuario navega a la web de Automation Practice")
    public void elUsuarioNavegaALaWebDeAutomationPractice() {
        AutomationPHomeService.navegarWeb();
    }

    @When("^el usuario pulsa el botón \"(.*)\"$")
    public void elUsuarioPulsaElBotón(String boton) {
        AutomationPHomeService.clickButton();
    }

    @Then("el usuario verifica que se enseña la pagina de Sign in")
    public void elUsuarioVerificaQueSeEnseñaLaPaginaDeSignIn() {
        AutomationPSignInService.verificarSignInPage();
    }

    @When("^el usuario realiza una busqueda de \"(.*)\"$")
    public void elUsuarioRealizaLaBusqueda(String pc){
        AutomationPHomeService.realizarBusqueda(pc);
    }
    @Then("^el usuario verifica que se muestran los productos con la palabra \"(.*)\"$")
    public void elUsuarioVerificaLaBusqueda(String pc){
        AutomationPSearchResultService.verificarBusqueda(pc);
    }
    @And("^el usuario ingresa su e-mail: \"(.*)\" y contraseña: \"(.*)\"$")
    public void elUsuarioSeLoguea(String email, String pass){
        AutomationPSignInService.logIn(email,pass);
    }

    @Then("^el usuario verifica que logro loguearse correctamente validando su nombre: \"(.*)\"$")
    public void elUsuarioVerificaElLogIn(String usserName){
        AutomationPSearchResultService.verificarLogIn(usserName);

    }
    @And("^el usuario ordena los productos segun: \"(.*)\"$")
    public void elUsuarioOrdenaLosProductos(String order){
        AutomationPSearchResultService.ordenarProductos(order);
    }
    @Then("^el usuario verifica el orden de los productos$")
    public void elUsuarioVerificaLaCantidadDeResultados(){
        AutomationPSearchResultService.verificarOrdenDeProductos();
    }


}
