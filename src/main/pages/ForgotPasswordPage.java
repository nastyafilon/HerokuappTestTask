package pages;

import core.utility.constants.ConfigurationConstants;
import core.web.driver.InitialDriver;
import core.web.ui.Button;
import core.web.ui.Field;
import core.web.ui.Label;
import org.openqa.selenium.By;

public class ForgotPasswordPage {
    public static final String PAGE_URL = ConfigurationConstants.BASE_URL + "forgot_password";

    Field field = new Field();
    Button button = new Button();
    Label label = new Label();

    private By emailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");
    private By successLabel = By.id("success");

    public static void openPage() {
        InitialDriver.getInstance().navigate().to(PAGE_URL);
    }

    public void enterEmail(String email) {
        field.type(emailField, email);
    }

    public void clickRetrievePasswordButton() {
        button.click(retrievePasswordButton);
    }

    public String getSuccessLabel() {
        return label.getText(successLabel);
    }

}
