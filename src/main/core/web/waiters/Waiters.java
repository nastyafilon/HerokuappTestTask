package core.web.waiters;

import core.web.driver.InitialDriver;
import core.utility.constants.ConfigurationConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Waiters {
    /**
     * It webDriver wait for all types of elements
     */
    public static WebDriverWait waitElement() {
        WebDriverWait wait = new WebDriverWait(InitialDriver.getInstance(), ConfigurationConstants.TIMEOUT);
        wait.pollingEvery(Duration.ofSeconds(ConfigurationConstants.POLLING));
        wait.ignoring(ElementClickInterceptedException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(InterruptedException.class);
        wait.ignoring(UnknownError.class);
        return wait;
    }

    /**
     * Wait until WebElement has state
     *  and then get this WebElement by locator
     */
    public static WebElement waitUntilClickable(WebElement element) {
        return waitElement().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilClickable(By locator) {
        return waitElement().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitUntilVisible(WebElement element) {
        return waitElement().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitUntilVisible(By locator) {
        return waitElement().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static List<WebElement> waitUntilVisibleAll(By locator) {
        return waitElement().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static WebElement waitUntilPresent(By locator) {
        return waitElement().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static List<WebElement> waitUntilPresentAll(By locator) {
        return waitElement().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    /**
     * ExpectedCondition<Boolean> waiters
     */
    public static void waitUntilSelected(WebElement element) {
        waitElement().until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void waitUntilSelected(By locator) {
        waitElement().until(ExpectedConditions.elementToBeSelected(locator));
    }

    public static void waitUntilInvisible(WebElement element) {
        waitElement().until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitUntilInvisible(By locator) {
        waitElement().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
