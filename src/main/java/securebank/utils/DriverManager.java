package securebank.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import securebank.config.ConfigManager;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public static void initDriver() {
        ConfigManager config = ConfigManager.getInstance();
        String browser = config.get("browser");
        boolean headless = config.getBoolean("browser.headless");
        boolean maximize = config.getBoolean("browser.window.maximize");
        int timeout = config.getInt("app.timeout");

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                if (headless) ffOptions.addArguments("--headless");
                driver = new FirefoxDriver(ffOptions);
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chOptions = new ChromeOptions();
                if (headless) chOptions.addArguments("--headless=new");
                chOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
                chOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chOptions);
            }
        }

        if (maximize) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout * 2));
        driver.manage().deleteAllCookies();

        driverThread.set(driver);
    }

    public static void quitDriver() {
        WebDriver driver = driverThread.get();
        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
    }
}
