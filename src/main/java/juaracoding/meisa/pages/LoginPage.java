package juaracoding.meisa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement txtError;

    public void loginUser(String user, String pwd) {
        username.sendKeys(user);
        password.sendKeys(pwd);
        btnLogin.click();
    }

    public String getErrorMessage() {
        return txtError.getText();
    }
}