import core.web.driver.InitialDriver;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RememberMePage;
import pages.SecurePage;

public class LoginTests {

    LoginPage loginPage = new LoginPage();
    SecurePage securePage = new SecurePage();
    RememberMePage rememberMePage = new RememberMePage();


    @BeforeMethod
    public void openLoginPage() {
        LoginPage.openPage();
    }

    @Test
    public void successfulLogin() {
        loginPage.enterCredentialsAndLogin("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(securePage.getTitle(), "Secure Area");
    }

    @Test(dataProvider = "invalidUsername")
    public void invalidUsernameLogin(final String username) {
        loginPage.enterCredentialsAndLogin(username, "SuperSecretPassword!");

        String actualLoginErrorText = loginPage.getLoginErrorLabel();
        Assert.assertTrue(actualLoginErrorText.contains("Your username is invalid!"), "Error is not shown");
    }

    @Test(dataProvider = "invalidPassword")
    public void invalidPasswordLogin(final String password) {
        loginPage.enterCredentialsAndLogin("tomsmith", password);

        String actualLoginErrorText = loginPage.getLoginErrorLabel();
        Assert.assertTrue(actualLoginErrorText.contains("Your password is invalid!"), "Error is not shown");
    }

    @Test
    public void loginWithEmptyUsername() {
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        String actualLoginErrorText = loginPage.getLoginErrorLabel();
        Assert.assertTrue(actualLoginErrorText.contains("Your username is invalid!"), "Error is not shown");
    }

    @Test
    public void loginWithEmptyPassword() {
        loginPage.enterUsername("tomsmith");
        loginPage.clickLoginButton();

        String actualLoginErrorText = loginPage.getLoginErrorLabel();
        Assert.assertTrue(actualLoginErrorText.contains("Your password is invalid!"),
                "Error is not shown, actual: " + actualLoginErrorText);
    }

    @Test
    public void checkboxesTestCase5() {
        rememberMePage.openPage();
        if(!rememberMePage.isSelectedCheckbox1())
            rememberMePage.clickCheckbox1();
        if(!rememberMePage.isSelectedCheckbox2())
            rememberMePage.clickCheckbox2();

        Assert.assertTrue(rememberMePage.isSelectedCheckbox1(), "Checkbox 1 is not selected");
        Assert.assertTrue(rememberMePage.isSelectedCheckbox2(), "Checkbox 2 is not selected");

        rememberMePage.clickCheckbox1();
        rememberMePage.clickCheckbox2();

        Assert.assertFalse(rememberMePage.isSelectedCheckbox1(), "Checkbox 1 is selected");
        Assert.assertFalse(rememberMePage.isSelectedCheckbox2(), "Checkbox 2 is selected");
    }

    @AfterMethod
    public void closeBrowser() {
        InitialDriver.destroy();
    }

    @DataProvider
    public Object[][] invalidUsername() {
        return new Object[][]
                {
                        { "tomsmith " },
                        { "user123" },
                        { ""}
                };
    }

    @DataProvider
    public Object[][] invalidPassword() {
        return new Object[][]
                {
                        { "SuperSecretPassword! " },
                        { "password123" },
                        { "" }
                };
    }
}
