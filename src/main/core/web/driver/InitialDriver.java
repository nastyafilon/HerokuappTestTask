package core.web.driver;

import core.utility.constants.ConfigurationConstants;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitialDriver {
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getInstance() {
        if (driverThread.get() == null) {
            driverThread.set(getWebDriver());
        }
        return driverThread.get();
    }

    private static WebDriver getWebDriver() {
        WebDriver driver;

        switch (ConfigurationConstants.BROWSER_NAME) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                System.out.println("Downloaded version: " + ChromeDriverManager.getInstance(DriverManagerType.CHROME).getDownloadedVersion());
                driver = new ChromeDriver(new BrowserOptions().chromeOptions());
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                System.out.println("Downloaded version: " + FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).getDownloadedVersion());
                driver = new FirefoxDriver(new BrowserOptions().firefoxOptions());
                break;
            default:
                WebDriverManager.edgedriver().setup();
                EdgeDriverManager.getInstance(DriverManagerType.EDGE).setup();
                System.out.println("Downloaded version: " + EdgeDriverManager.getInstance(DriverManagerType.EDGE).getDownloadedVersion());
                driver = new EdgeDriver(new BrowserOptions().edgeOptions());
                break;
        }

        return driver;
    }

    public static void destroy() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.set(null);
        }
    }
}
