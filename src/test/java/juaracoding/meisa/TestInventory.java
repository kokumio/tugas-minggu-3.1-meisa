package juaracoding.meisa;

import juaracoding.meisa;.pages.InventoryPage;
import juaracoding.meisa.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestInventory {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test(priority = 1)
    public void testLoginNegatif() {
        loginPage.loginUser("wrong_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @Test(priority = 2)
    public void testLoginPositif() {
        loginPage.loginUser("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 3)
    public void testAddToCart() {
        loginPage.loginUser("standard_user", "secret_sauce"); // Pre-condition
        inventoryPage.clickAddToCart();
        
        Assert.assertEquals(inventoryPage.getBtnText(), "Remove");
        Assert.assertEquals(inventoryPage.getCartBadgeText(), "1");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}