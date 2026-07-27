package securebank.pages;

import org.openqa.selenium.By;
import securebank.config.ConfigManager;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.id("login-button");
    private final By errorMessage  = By.cssSelector("[data-test='error']");
    private final By logo          = By.className("login_logo");

    public LoginPage() {
        super();
    }

    public void open() {
        driver.get(ConfigManager.getInstance().get("app.url"));
    }

    public boolean isLogoVisible() {
        return isDisplayed(logo);
    }

    public void loginAs(String user, String pass) {
        type(usernameInput, user);
        type(passwordInput, pass);
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage);
    }

    
}
