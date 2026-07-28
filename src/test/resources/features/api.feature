# language: es
@api @regression
Característica: API de SecureBank
  Como sistema bancario
  Quiero exponer APIs REST seguras
  Para que las apps clientes puedan operar

  @smoke @login
  Escenario: Login API exitoso
    Cuando envío credenciales válidas a la API
    Entonces recibo status 200
    Y el token de sesión

  @security
  Escenario: API rechaza SQL Injection
    Cuando envío credenciales con SQL Injection
    Entonces recibo status 401

  @balance
  Escenario: Consulta de saldo API
    Dado que estoy autenticado en la API
    Cuando consulto mi saldo
    Entonces recibo status 200
    Y el saldo es mayor a 0
