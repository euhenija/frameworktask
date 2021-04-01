package webdrivertasks.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetUp {
    private static WebDriver driver;

    private WebDriverSetUp() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setupDriver();
        }
        return driver;
    }

    private static void setupDriver() {
        switch (System.getenv("driver")) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new ChromeDriver();
        }
    }
}
