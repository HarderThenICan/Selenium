package HW6;


import io.qameta.allure.Step;
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

    @Step("Заполнение формы логина")
    public LoginPage fillLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Заполнение формы пароля")
    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку отправки формы авторизации")
    public InfoPage clickLoginButton() {
        loginButton.click();
        return new InfoPage(driver);
    }

}
