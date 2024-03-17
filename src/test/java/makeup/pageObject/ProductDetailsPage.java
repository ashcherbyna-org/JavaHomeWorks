package makeup.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    private final WebDriver driver;
    private static final String PURCHASE_OPTION = "/html/body/div/div[1]/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[2]";
    private static final String COUNT_OF_ITEMS = "/html/body/div/div[2]/div/div[1]/div[2]/div[1]/ul/li/div[2]/div[1]/div[1]/input";
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebElement purchaseOption;
    private WebElement countOfItems;
    public String purchase() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PURCHASE_OPTION)));
        purchaseOption = driver.findElement(By.xpath(PURCHASE_OPTION));
        purchaseOption.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(COUNT_OF_ITEMS)));
        countOfItems = driver.findElement(By.xpath(COUNT_OF_ITEMS));
        return countOfItems.getAttribute("value");
    }


}
