package core.web.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

import static core.web.waiters.Waiters.waitUntilClickable;

public class Button extends ElementProperties {

    public void click(By element) {
        WebElement button = waitUntilClickable(element);
        button.click();
    }

    public void uploadFile(By locator, String pathToFile) {
        WebElement uploadButton = waitUntilClickable(locator);
        uploadButton.sendKeys(System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "resources" + File.separator
                + pathToFile);
    }

}
