package makeup.tests;

import makeup.pageObject.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginPageTests {
    private static final String baseUrl = "https://makeup.pl/";

    @BeforeMethod
    public void startBrowser() {
    }

    @AfterMethod
    public void closeBrowser() {
    }

    @Test
    public void loginStandardUser() throws InterruptedException, MalformedURLException {
        var gridUrl = "http://192.168.1.6:4444/";
        var options = new ChromeOptions();
        var driver = new RemoteWebDriver(new URL(gridUrl), options);
        var loginEmail = "anastasiavictorivna1@gmail.com";
        var password = "Zse45aw3";
        driver.get(baseUrl);
        var loginpage = new LoginPage(driver);
        loginpage.login(loginEmail, password);
        driver.close();
    }

    @Test
    public void loginInlaidUser() throws InterruptedException, MalformedURLException {
        var gridUrl = "http://192.168.1.6:4444/";
        var options = new FirefoxOptions();
        var driver = new RemoteWebDriver(new URL(gridUrl), options);
        var loginEmail = "anastasiavictorivna11@gmail.com";
        var password = "Qwerty12!!";
        driver.get(baseUrl);
        var loginPage = new LoginPage(driver);
        var invalidText = loginPage.invalidLogin(loginEmail, password);
        Assert.assertEquals(invalidText, "Zbyt dużo nieudanych prób. Spróbuj ponownie później lub skorzystaj z funkcji \"Nie pamiętam hasła\".");
        driver.close();
    }

}


