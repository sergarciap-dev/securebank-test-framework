# language: es
@regression
Característica: Login de usuarios en SecureBank
  Como usuario registrado
  Quiero poder iniciar sesión
  Para acceder a mi cuenta bancaria

  @smoke @happy-path
  Escenario: Login exitoso con credenciales válidas
    Dado que el usuario está en la página de login
    Cuando ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    Entonces debería ver la página de inventario
    Y el título debería ser "Products"

  @negative
  Escenario: Login fallido con usuario bloqueado
    Dado que el usuario está en la página de login
    Cuando ingresa el usuario "locked_out_user" y la contraseña "secret_sauce"
    Entonces debería ver un mensaje de error
    Y el mensaje debería contener "locked out"

  @security
  Escenario: Intento de SQL Injection en el login
    Dado que el usuario está en la página de login
    Cuando ingresa el usuario "' OR '1'='1" y la contraseña "cualquiera"
    Entonces debería ver un mensaje de error
    Y NO debería estar autenticado

  @data-driven
  Esquema del escenario: Validar múltiples credenciales
    Dado que el usuario está en la página de login
    Cuando ingresa el usuario "<usuario>" y la contraseña "<password>"
    Entonces debería ver "<resultado>"

    Ejemplos:
      | usuario        | password      | resultado              |
      | standard_user  | secret_sauce  | la página de inventario |
      | locked_out_user| secret_sauce  | un mensaje de error    |
      | problem_user   | secret_sauce  | la página de inventario |
