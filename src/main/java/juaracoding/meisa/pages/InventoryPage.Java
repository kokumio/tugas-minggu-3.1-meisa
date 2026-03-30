package juaracoding.meisa.pages; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement btnAddToCart;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement btnRemove;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    public void addProductToCart() {
        btnAddToCart.click();
    }

    public String getButtonText() {
        return btnRemove.getText();
    }

    // 2. Samakan namanya dengan yang dipanggil di InventoryTest
    public String getCartBadgeText() { 
        return cartBadge.getText();
    }
}