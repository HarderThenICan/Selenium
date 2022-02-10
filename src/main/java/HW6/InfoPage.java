package HW6;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class InfoPage extends BasePage {

    public InfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='fa fa-car']")
    private WebElement carListButton;

    @Step("Проверка URL страницы")
    public void checkUrl() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fa fa-money-bill bg-gray']")));
        String URL = driver.getCurrentUrl();
        assertEquals("https://cabinet.parkomatica.ru/info", URL);

    }

    @Step("Клик на кнопку списка автомобилей")
    public CarListPage clickCarListButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fa fa-car']")));
        carListButton.click();
        return new CarListPage(driver);
    }
}
