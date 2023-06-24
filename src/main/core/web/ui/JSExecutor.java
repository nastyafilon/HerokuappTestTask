package core.web.ui;

import core.web.driver.InitialDriver;
import org.openqa.selenium.JavascriptExecutor;

public class JSExecutor {

    /**
     * @return Selenium Java Script Executor
     */
    public static JavascriptExecutor javascriptExecutor() {
        return (JavascriptExecutor) InitialDriver.getInstance();
    }
}
