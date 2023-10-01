Feature: Buscar producto en mercado libre

  Scenario Outline: Comprar monitor en mercado libre
    Given Abro navegador en modo incognito
    When Me encuentro en la página de Mercado Libre y acepto cookies
    Then Busco el producto monitor
    Then Una vez seleccionado el producto voy a comprarlo como cliente nuevo
    And Diligencio el formulario de registro con <firstName> <lastName> <email> <password>
    Then se cierra el navegador automaticamente

    Examples:
      | firstName | lastName | email              | password  |
      | Andres    | Leon     | pruebass2@gmail.comm | prueba123 |

