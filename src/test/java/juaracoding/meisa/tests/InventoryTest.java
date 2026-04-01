package juaracoding.meisa.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import juaracoding.meisa.pages.LoginPage;
import juaracoding.meisa.pages.InventoryPage;
import juaracoding.meisa.pages.CheckoutPage; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class InventoryTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckoutPage checkoutPage; 

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutPage = new CheckoutPage(driver); // Inisialisasi di sini
        
        // Precondition: Login dulu
        loginPage.loginUser("standard_user", "secret_sauce");
    }

    @Test(priority = 1)
    public void testAddToCart() {
        inventoryPage.addProductToCart();
        Assert.assertEquals(inventoryPage.getButtonText(), "Remove");
        Assert.assertEquals(inventoryPage.getCartBadgeText(), "1");
    }

    @Test(priority = 2)
    public void testCheckoutProcess() {
        inventoryPage.goToCart(); // Klik ikon keranjang
        
        // Isi data checkout (Nama Depan, Nama Belakang, Kode Pos)
        checkoutPage.checkoutProcess("Meisa", "Juara", "12345");
        
        // Assert: Cek apakah muncul pesan sukses
        Assert.assertEquals(checkoutPage.getFinishMessage(), "Thank you for your order!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            try {
                Thread.sleep(3000); // Biar Meisa bisa lihat hasil akhirnya
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}