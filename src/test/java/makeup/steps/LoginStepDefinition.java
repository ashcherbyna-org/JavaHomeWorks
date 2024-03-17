package makeup.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import makeup.pageObject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class LoginStepDefinition {
    private WebDriver driver;
    private static final String baseUrl = "https://makeup.pl/";
    private String errorText;

    @Before
    public void setUp() throws MalformedURLException {
        var gridUrl = "http://192.168.1.6:4444/";
        var options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL(gridUrl), options);
    }

    @Given("User is on the Login Page")
    public void loginPage(){
        driver.get(baseUrl);
    }

    @When("User enters valid credential")
    public void entersValidCredential(DataTable dataTable)
    {
        List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> form : user) {
            var loginpage = new LoginPage(driver);
            loginpage.login(form.get("Username"), form.get("Password"));
        }
    }

    @When("User enters invalid credential")
    public void entersInvalidCredential(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> form : user) {
            var loginpage = new LoginPage(driver);
            errorText = loginpage.invalidLogin(form.get("Username"), form.get("Password"));
        }
    }

    @Then(("User should be able to see error message {string}"))
    public void verifyErrorMassage(String errorMassage) {
        Assert.assertEquals(errorText, errorMassage);
    }

    @After
    public void CloseBrowser(){
        driver.close();
    }



}
