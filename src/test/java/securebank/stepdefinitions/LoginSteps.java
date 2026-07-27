package securebank.stepdefinitions;

import io.cucumber.java.es.*;
import org.testng.Assert;
import securebank.pages.InventoryPage;
import securebank.pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Dado("que el usuario está en la página de login")
    public void openLoginPage() {
        loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isLogoVisible(), "❌ El logo no se muestra");
    }

    @Cuando("ingresa el usuario {string} y la contraseña {string}")
    public void enterCredentials(String user, String pass) {
        loginPage.loginAs(user, pass);
    }

    @Entonces("debería ver la página de inventario")
    public void verifyInventoryPage() {
        inventoryPage = new InventoryPage();
        Assert.assertTrue(inventoryPage.isOnInventoryPage(),
                "❌ No se cargó la página de inventario");
    }

    @Y("el título debería ser {string}")
    public void verifyTitle(String expected) {
        Assert.assertEquals(inventoryPage.getPageTitle(), expected);
    }

    @Entonces("debería ver un mensaje de error")
    public void verifyErrorMessage() {
        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "❌ No se mostró mensaje de error");
    }

    @Y("el mensaje debería contener {string}")
    public void verifyErrorContains(String text) {
        Assert.assertTrue(loginPage.getErrorMessage().contains(text),
                "❌ El mensaje no contiene: " + text);
    }

    @Y("NO debería estar autenticado")
    public void verifyNotAuthenticated() {
        Assert.assertTrue(loginPage.isLogoVisible(),
                "❌ El usuario fue autenticado indebidamente");
    }

    @Entonces("debería ver {string}")
    public void shouldSee(String expected) {
        switch (expected) {
            case "la página de inventario" -> {
                if (inventoryPage == null) {
                    inventoryPage = new InventoryPage();
                }
                Assert.assertTrue(inventoryPage.isOnInventoryPage(),
                        "❌ No se cargó la página de inventario");
            }
            case "un mensaje de error" -> Assert.assertTrue(loginPage.isErrorDisplayed(),
                    "❌ No se mostró mensaje de error");
            default -> throw new IllegalArgumentException("❌ Caso no manejado: " + expected);
        }
    }
}
