package juaracoding.meisa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    WebElement btnCheckout;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement btnContinue;

    @FindBy(id = "finish")
    WebElement btnFinish;

    @FindBy(className = "complete-header")
    WebElement txtFinishHeader;

    public void checkoutProcess(String fName, String lName, String pCode) {
        btnCheckout.click();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        postalCode.sendKeys(pCode);
        btnContinue.click();
        btnFinish.click();
    }

    public String getFinishMessage() {
        return txtFinishHeader.getText();
    }
}