Feature: Buscar producto en mercado libre

  Scenario Outline: Comprar monitor en mercado libre
    Given Abro navegador en modo incognito
    When Me encuentro en la pagina de mercado libre y acepto cookies
    Then Busco el producto monitor
    Then Una vez seleccionado el producto voy a comprarlo como cliente nuevo
    And Diligencio el formulario de registro con <firstName> <lastName> <email> <password>
    Then Acepto terminos y condiciones
    And Valido si aparece captcha
    And Hago clic en continuar
    Then Se visualiza pagina para envio de codigo

    Examples: 
      | firstName | lastName | email              | password  |
      | Andres    | Leon     | prueba@gmail.commm | prueba123 |

      