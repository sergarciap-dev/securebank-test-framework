package securebank.stepdefinitions;

import io.cucumber.java.es.*;
import io.restassured.response.Response;
import org.testng.Assert;
import securebank.api.ApiClient;

public class ApiSteps {

    private ApiClient api = new ApiClient();
    private Response response;
    private String token;

    @Cuando("envío credenciales válidas a la API")
    public void validLogin() {
        response = api.login("eve.holt@reqres.in", "cityslicka");
    }

    @Entonces("recibo status {int}")
    public void verifyStatus(int expected) {
        Assert.assertEquals(response.getStatusCode(), expected);
    }

    @Y("el token de sesión")
    public void verifyToken() {
        token = response.jsonPath().getString("token");
        Assert.assertNotNull(token, "❌ No se recibió token");
    }

    @Cuando("envío credenciales con SQL Injection")
    public void sqlInjection() {
        response = api.login("' OR '1'='1", "anything");
    }

    @Dado("que estoy autenticado en la API")
    public void authenticated() {
        response = api.login("eve.holt@reqres.in", "cityslicka");
        token = response.jsonPath().getString("token");
    }

    @Cuando("consulto mi saldo")
    public void checkBalance() {
        response = api.getBalance(token);
    }

    @Y("el saldo es mayor a {int}")
    public void verifyBalance(int min) {
        int balance = response.jsonPath().getInt("data.balance");
        Assert.assertTrue(balance > min, "❌ Saldo: " + balance);
    }
}
