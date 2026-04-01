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

    @FindBy(className = "shopping_cart_link")
    WebElement btnCart;

    public void addProductToCart() {
        btnAddToCart.click();
    }

    public String getButtonText() {
        return btnRemove.getText();
    }

    public String getCartBadgeText() { 
        return cartBadge.getText();
    }

    public void goToCart() {
        btnCart.click();
    }
}