package core.web.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.web.waiters.Waiters.*;

public class ElementProperties extends Element {

    /**
     * Check states of element
     */
    public boolean isPresent(By locator) {
        try {
            return waitUntilPresent(locator) != null;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isSelected(WebElement element) {
        waitUntilSelected(element);
        return element.isSelected();
    }

    public boolean isSelected(By locator) {
        waitUntilSelected(locator);
        return new Element().getElementBy(locator).isSelected();
    }

    //isEnabled
    public boolean isClickable(WebElement element) {
        return waitUntilClickable(element).isEnabled();
    }

    public boolean isClickable(By locator) {
        return waitUntilClickable(locator).isEnabled();
    }

    //isDisplayed
    public boolean isVisible(WebElement element) {
        return waitUntilVisible(element).isDisplayed();
    }

    public boolean isVisible(By locator) {
        return waitUntilVisible(locator).isDisplayed();
    }

    public boolean isInvisible(WebElement element) {
        waitUntilInvisible(element);
        return !element.isDisplayed();
    }

    public boolean isInvisible(By locator) {
        waitUntilInvisible(locator);
        return !getElementBy(locator).isDisplayed();
    }

    public boolean isClassEqualTo(By locator, String className) {
        return waitElement().until(ExpectedConditions.attributeToBe(locator, "class", className));
    }

    public boolean isTextContained(WebElement element, String text) {
        return waitElement().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean isTextContained(By locator, String text) {
        return waitElement().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public boolean isTextEqual(By locator, String text) {
        return waitElement().until(ExpectedConditions.textToBe(locator, text));
    }

    public boolean isTextNotEqual(By locator, String text) {
        return waitElement().until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }


    /**
     * Get attribute of element
     */
    public String getAttribute(By locator, String attribute) {
        return waitUntilPresent(locator).getAttribute(attribute);
    }

    public String getAttributeValue(By locator) {
        return waitUntilPresent(locator).getAttribute("value");
    }

    public boolean getAttributeDisabled(By locator) {
        return Boolean.parseBoolean(
                waitUntilPresent(locator).getAttribute("disabled"));
    }

    public String getCssValueBackground(By locator) {
        return waitUntilVisible(locator).getCssValue("background");
    }

    public String getTxt(By locator) {
        return waitUntilVisible(locator).getText();
    }


}
