import core.web.driver.InitialDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.RememberMePage;

public class ForgotPasswordTests {

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test
    public void forgotPassword() {
        forgotPasswordPage.openPage();
        forgotPasswordPage.enterEmail("tomsmith@herokuapp.com");
        forgotPasswordPage.clickRetrievePasswordButton();

        String actualSuccessText = forgotPasswordPage.getSuccessLabel();
        Assert.assertTrue(actualSuccessText.contains("Password reset instructions have been sent to the email address"),
                "Error is not shown"); // todo BUG internal server error
    }


    @AfterMethod
    public void closeBrowser() {
        InitialDriver.destroy();
    }
}
