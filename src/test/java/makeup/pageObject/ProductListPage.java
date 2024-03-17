package makeup.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductListPage {
    private final WebDriver driver;

    private static final String SELECT_ITEM = "/html/body/div[1]/div[2]/div/div/div[2]/div[1]/div/div[6]/ul/li[3]";

    private WebElement selectItemOnPage;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void findItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SELECT_ITEM)));
        selectItemOnPage = driver.findElement(By.xpath(SELECT_ITEM));
        selectItemOnPage.click();
    }
}