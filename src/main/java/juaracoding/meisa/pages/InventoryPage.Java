package juaracoding.namapeserta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    private WebDriver driver;

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

    public void clickAddToCart() {
        btnAddToCart.click();
    }

    public String getBtnText() {
        return btnRemove.getText();
    }

    public String getCartBadgeText() {
        return cartBadge.getText();
    }
}