package core.web.ui;

import core.web.waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Label extends ElementProperties {

    public String getText(By element) {
        WebElement field = Waiters.waitUntilVisible(element);
        return field.getText();
    }
}
