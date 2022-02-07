package HW6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "loginform-email")
    private WebElement loginInput;

    @FindBy(id = "loginform-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    public LoginPage fillLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public InfoPage clickLoginButton() {
        loginButton.click();
        return new InfoPage(driver);
    }

}
