package securebank.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import securebank.config.ConfigManager;
import securebank.utils.DriverManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.initDriver();
        DriverManager.getDriver().get(ConfigManager.getInstance().get("app.url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && ConfigManager.getInstance().getBoolean("screenshot.on.failure")) {
            takeScreenshot(scenario);
        }
        DriverManager.quitDriver();
    }

    private void takeScreenshot(Scenario scenario) {
        try {
            File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String path = "target/screenshots/" + scenario.getName().replaceAll(" ", "_")
                    + "_" + timestamp + ".png";
            FileUtils.copyFile(src, new File(path));
            System.out.println("📸 Screenshot guardado: " + path);
        } catch (IOException e) {
            System.out.println("⚠️ No se pudo guardar screenshot: " + e.getMessage());
        }
    }
}
