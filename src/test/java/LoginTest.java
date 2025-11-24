import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void CheckIncorrectLogin() throws InterruptedException {
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        // Thread.sleep(9000);
        assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void CheckCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productPage.isPageLoaded(), "Register btn is not visible");

        //Alert alert = driver.switchTo().alert();
        //alert.accept();
        //alert.dismiss();
        //alert.getText();
    }
}
