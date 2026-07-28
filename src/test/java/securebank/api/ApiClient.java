package securebank.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import securebank.config.ConfigManager;

public class ApiClient {

    public ApiClient() {
        RestAssured.baseURI = ConfigManager.getInstance().get("api.base.url");
    }

    public Response login(String user, String pass) {
        return RestAssured
            .given()
                .header("x-api-key", "reqres-free-v1")  // ← NUEVO
                .contentType("application/json")
                .body("{\"email\":\"" + user + "\",\"password\":\"" + pass + "\"}")
            .when()
                .post("/login");
    }

    public Response getBalance(String token) {
        return RestAssured
            .given()
                .header("x-api-key", "reqres-free-v1")  // ← NUEVO
                .header("Authorization", "Bearer " + token)
            .when()
                .get("/balance");
    }
}
