Feature: Como usuario, quiero navegar a la web de Automation practice, para utilizar sus funciones

  @Smoke @Ignore
  Scenario: El usuario navega a "Sign in"
    Given el usuario navega a la web de Automation Practice
    When el usuario pulsa el botón "Sign in"
    Then el usuario verifica que se enseña la pagina de Sign in

  @Smoke
  Scenario Outline: El usuario realiza una busqueda
    Given el usuario navega a la web de Automation Practice
    When el usuario realiza una busqueda de "<keyword>"
    Then el usuario verifica que se muestran los productos con la palabra "<keyword>"

    Examples:
      | keyword |
      | blouse  |
      | printed |
      | dress   |

  @Smoke
  Scenario: El usuario se loguea -Happy Path-
    Given el usuario navega a la web de Automation Practice
    When el usuario pulsa el botón "Sign in"
    And el usuario ingresa su e-mail: "practicacrow@gmail.com" y contraseña: "123456789"
    Then el usuario verifica que logro loguearse correctamente validando su nombre: "Crow dar"


  @Smoke
  Scenario Outline: El usuario ordena los productos
    Given el usuario navega a la web de Automation Practice
    When el usuario realiza una busqueda de "<clothing>"
    And el usuario ordena los productos segun: "Price: Lowest first"
    Then el usuario verifica el orden de los productos

    Examples:
      | clothing |
      | chiffon  |
      | printed  |