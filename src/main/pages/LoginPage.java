package pages;

import core.utility.constants.ConfigurationConstants;
import core.web.driver.InitialDriver;
import core.web.ui.Button;
import core.web.ui.Field;
import core.web.ui.Label;
import org.openqa.selenium.By;

public class LoginPage {
    public static final String PAGE_URL = ConfigurationConstants.BASE_URL + "login";

    Field field = new Field();
    Button button = new Button();
    Label label = new Label();

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.className("radius");
    private By loginErrorLabel = By.className("error");

    public static void openPage() {
        InitialDriver.getInstance().navigate().to(PAGE_URL);
    }

    public void enterUsername(String username) {
        field.type(usernameField, username);
    }

    public void enterPassword(String password) {
        field.type(usernameField, password);
    }

    public void clickLoginButton() {
        button.click(loginButton);
    }

    public void enterCredentialsAndLogin(String username, String password) {
        field.type(usernameField, username);
        field.type(passwordField, password);
        button.click(loginButton);
    }

    public String getLoginErrorLabel() {
        return label.getText(loginErrorLabel);
    }

}
