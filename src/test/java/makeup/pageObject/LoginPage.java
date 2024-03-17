package makeup.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private WebDriver driver;
    private static final String USER_LOCATOR = "/html/body/div[1]/div[1]/header/div[2]/div/div[3]/div[1]";
    private static final String USER_EMAIL_LOCATOR = "//*[@id=\"login\"]";
    private static final String USER_PASSWORD_LOCATOR = "//*[@id=\"pw\"]";
    private static final String OPTION_LOCATOR = "//*[@id=\"form-auth\"]/div/div/div[4]/button";
    private static final String WARNING_ERROR = "//*[@id=\"popup__window\"]/div[2]";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        userOption = driver.findElement(By.xpath(USER_LOCATOR));
        userEmailElement = driver.findElement(By.xpath(USER_EMAIL_LOCATOR));
        userPasswordElement = driver.findElement(By.xpath(USER_PASSWORD_LOCATOR));
        loginButton = driver.findElement(By.xpath(OPTION_LOCATOR));
    }

    private WebElement userOption;
    private WebElement userEmailElement;
    private WebElement userPasswordElement;
    private WebElement loginButton;
    private WebElement warningMassage;

    public void login(String userEmail, String password) {
        userOption.click();
        userEmailElement.sendKeys(userEmail);
        userPasswordElement.sendKeys(password);
        loginButton.click();
    }

    public String invalidLogin(String userEmail, String password) throws InterruptedException {
        userOption.click();
        userEmailElement.sendKeys(userEmail);
        userPasswordElement.sendKeys(password);
        var maxAttemts = 4;
        List<WebElement> warningMassages = new ArrayList<>();
        var actions = new Actions(driver);
        while (warningMassages.isEmpty() && maxAttemts > 0) {
            loginButton.click();
            actions.pause(500).perform();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
            warningMassages = driver.findElements(By.xpath(WARNING_ERROR));
            maxAttemts--;
        }
        warningMassage = warningMassages.getFirst();
        return warningMassage.getText();
    }
}