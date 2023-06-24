package pages;

import core.utility.constants.ConfigurationConstants;
import core.web.driver.InitialDriver;
import core.web.ui.Element;
import org.openqa.selenium.By;

public class RememberMePage {
    Element element = new Element();
    public static final String PAGE_URL = ConfigurationConstants.BASE_URL + "checkboxes";

    private By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    private By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public static void openPage() {
        InitialDriver.getInstance().navigate().to(PAGE_URL);
    }

    public void clickCheckbox1() {
        element.getElementBy(checkbox1).click();
    }

    public void clickCheckbox2() {
        element.getElementBy(checkbox2).click();
    }

    public boolean isSelectedCheckbox1() {
        return element.getElementBy(checkbox1).isSelected();
    }

    public boolean isSelectedCheckbox2() {
        return element.getElementBy(checkbox2).isSelected();
    }
}
