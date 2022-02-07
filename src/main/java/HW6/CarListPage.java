package HW6;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;

public class CarListPage extends BasePage {
    public CarListPage (WebDriver driver) {
        super(driver);
    }
    private final static String ADD_CAR_BUTTON_LOCATOR_BY_XPATH =
            "//*[@class='text-right']/a[@href='/car/create']";
    @FindBy(xpath = ADD_CAR_BUTTON_LOCATOR_BY_XPATH)
    private WebElement addCarButton;


    public void checkCarInList(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='box-body']")));
        MatcherAssert.assertThat(driver.findElement(By.xpath("//a[contains(@href, '/car/view?id=152299')]")),hasText("а111аа01"));
    }


    public AddCarFormPage ClickaddCarButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_CAR_BUTTON_LOCATOR_BY_XPATH)));
        addCarButton.click();
        return new AddCarFormPage(driver);
    }
}
