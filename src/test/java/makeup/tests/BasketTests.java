package makeup.tests;

import makeup.pageObject.MainPage;
import makeup.pageObject.ProductDetailsPage;
import makeup.pageObject.ProductListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasketTests {
    private static WebDriver driver;
    private static final String baseUrl = "https://makeup.pl/";

    @BeforeTest
    public void startBrowser(){
        driver = new ChromeDriver();
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void addItemIntoBasket(){
        driver.get(baseUrl);
        var mainPage = new MainPage(driver);
        mainPage.searchVehicleOnPage("Dior Sauvage");
        var productListPage = new ProductListPage(driver);
        productListPage.findItem();
        var productDetailPage = new ProductDetailsPage(driver);
        var count = productDetailPage.purchase();
        Assert.assertEquals(count, "1");
    }

}

