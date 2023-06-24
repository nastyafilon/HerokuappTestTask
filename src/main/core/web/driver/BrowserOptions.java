package core.web.driver;


import core.utility.constants.ConfigurationConstants;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
public class BrowserOptions {

    ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(ConfigurationConstants.IS_HEADLESS);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        return options;
    }

    FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        return options;
    }

    EdgeOptions edgeOptions() {
        EdgeOptions options = new EdgeOptions();
        return options;
    }
}

