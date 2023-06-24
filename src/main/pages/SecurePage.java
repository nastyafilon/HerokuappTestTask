package pages;

import core.utility.constants.ConfigurationConstants;
import core.web.driver.InitialDriver;
import core.web.ui.Button;
import core.web.ui.Label;
import org.openqa.selenium.By;

public class SecurePage {
    public static final String PAGE_URL = ConfigurationConstants.BASE_URL + "secure";

    Label label = new Label();
    Button button = new Button();

    private By pageTitle = By.cssSelector(".example h2");
    private By subheaderLabel = By.className("subheader");
    private By logoutButton = By.className("radius");


    public static void openPage() {
        InitialDriver.getInstance().navigate().to(PAGE_URL);
    }

    public String getTitle() {
        return label.getText(pageTitle);
    }

    public String getSubheader() {
        return label.getText(subheaderLabel);
    }

    public void clickLogoutButton() {
        button.click(logoutButton);
    }
}
