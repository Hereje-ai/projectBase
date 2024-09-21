#autor Andres Cruz

Feature: Abrir una página web

  Yo como usuario
  Quiero realizar una prueba de abrir una pagina
  Para comprobar que se carguen los recursos correctamente

  Background:
    Given "usuario" abre el sitio web de pruebas

@successful
  Scenario: validacion en la funcion del ID Card Elements
  And desea validar la funcion de la carta de elementos
  When selecciona aleatoriamente alguna de las subfunciones
  Then visualizara en la cabecera el nombre de la opcion elegida