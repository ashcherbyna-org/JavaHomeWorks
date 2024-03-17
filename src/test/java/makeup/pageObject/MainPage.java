package makeup.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    private static final String SEARCH_OPTION = "/html/body/div[1]/div[1]/header/div[2]/div/div[1]/div[2]";
    private static final String SEARCH_INPUT= "//*[@id=\"search-input\"]";
    private static final String SEARCH_ITEM = "//*[@id=\"search-modal-container\"]/button[1]";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement searchOption;
    private WebElement searchItem;
    private WebElement searchInput;

    public void searchVehicleOnPage(String searchText) {
        driver.manage().window().maximize();
        searchOption = driver.findElement(By.xpath(SEARCH_OPTION));
        searchOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        searchInput = driver.findElement(By.xpath(SEARCH_INPUT));
        searchInput.sendKeys(searchText);
        searchItem = driver.findElement(By.xpath(SEARCH_ITEM));
        searchItem.click();
    }
}
