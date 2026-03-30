package juaracoding.meisa.tests;

import org.openqa.selenium.WebDriver; // Tambahkan ini agar aman
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import juaracoding.meisa.pages.InventoryPage;
import juaracoding.meisa.pages.LoginPage;

public class InventoryTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Pastikan driver ter-setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        
        // Precondition: Login sukses agar bisa masuk ke Inventory
        loginPage.loginUser("standard_user", "secret_sauce");
    }

    @Test(priority = 1)
    public void testAddToCartPositive() {
        inventoryPage.addProductToCart();
        
        // Assertions: Pastikan teks tombol berubah jadi Remove
        Assert.assertEquals(inventoryPage.getButtonText(), "Remove");
        
        // Pastikan nama method ini SAMA dengan yang ada di InventoryPage.java
        Assert.assertEquals(inventoryPage.getCartBadgeText(), "1"); 
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}