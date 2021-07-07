Feature: Buscar producto en mercado libre

  Scenario Outline: Busqueda de texto para validar el titulo de la pagina resupesta
    Given abro navegador en modo incognito
    When me encuentro en la pagina de mercado libre
    Then busco el producto monitor
    Then una vez seleccionado el producto voy a comprarlo como cliente nuevo
    And lleno el formulario e ingreso <firstName> <lastName> <email> <password>
    Then acepto terminos y condiciones
    And hago clic en continuar

    Examples: 
      | firstName | lastName | email              | password  |
      | Andres    | Leon     | prueba@gmail.commm | prueba123 |
