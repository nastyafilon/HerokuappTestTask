package core.web.ui;

import java.util.Set;

public class Windows extends ElementProperties {

    public void open(String url) {
        driver.get(url);
    }

    public Set<String> getAllWindowsNames() {
        return driver.getWindowHandles();
    }


    public class Frame {
        public void switchToFrame(String frameName) {
            driver.switchTo().frame(frameName);
        }

        public void switchToFrame(int frameIndex) {
            driver.switchTo().frame(frameIndex);
        }

        public void exitToDefaultContent() {
            driver.switchTo().defaultContent();
        }
    }

    public class Tab {

        public void switchToLastWindow() {
            Set<String> openedWindows = driver.getWindowHandles();
            openedWindows.iterator().forEachRemaining(
                    window -> driver.switchTo().window(window));
        }
    }

    public class Alert {
        public void accept() {
            driver.switchTo().alert().accept();
        }

        public void dismiss() {
            driver.switchTo().alert().dismiss();
        }

        public String getMessage() {
            return driver.switchTo().alert().getText();
        }

        public void enterMessage(String text) {
            driver.switchTo().alert().sendKeys(text);
        }

    }
}
