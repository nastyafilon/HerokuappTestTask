package core.web.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Mouse extends ElementProperties {

    public void moveToElement(By element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(element));
        builder.build().perform();
    }
}

