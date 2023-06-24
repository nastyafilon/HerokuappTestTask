package core.web.ui;

import core.web.waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Field extends ElementProperties {

    public void type(By element, String text) {
        WebElement field = Waiters.waitUntilVisible(element);
        field.clear();
        field.sendKeys(text);
    }

    public String getText(By element) {
        WebElement field = Waiters.waitUntilVisible(element);
        return field.getText();
    }

}
