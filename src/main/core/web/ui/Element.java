package core.web.ui;

import core.web.driver.InitialDriver;
import org.openqa.selenium.*;

import java.util.List;

import static core.web.waiters.Waiters.*;

public class Element {

    protected WebDriver driver = InitialDriver.getInstance();

    //=====================
    // Get elements if they are visible
    //=====================
    public WebElement getElementBy(By locator) {
        waitUntilVisible(locator);
        return driver.findElement(locator);
    }

    public List<WebElement> getElementsList(By locator) {
        waitUntilVisibleAll(locator);
        return driver.findElements(locator);
    }

    public WebElement getElementFromList(By locator, int index) {
        waitUntilVisibleAll(locator);
        return driver.findElements(locator).get(index);
    }
}
