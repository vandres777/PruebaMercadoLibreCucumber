Feature: Buscar producto en mercado libre

  Scenario Outline: Busqueda de texto para validar el titulo de la pagina resupesta
    Given Abro navegador en modo incognito
    When Me encuentro en la pagina de mercado libre y acepto cookies
    Then Busco el producto monitor
    Then Una vez seleccionado el producto voy a comprarlo como cliente nuevo
    And Lleno el formulario e ingreso <firstName> <lastName> <email> <password>
    Then Acepto terminos y condiciones
    And Valido si aparece captcha
    And Hago clic en continuar

    Examples: 
      | firstName | lastName | email              | password  |
      | Andres    | Leon     | prueba@gmail.commm | prueba123 |

      