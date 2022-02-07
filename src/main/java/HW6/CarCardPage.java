package HW6;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;

public class CarCardPage extends BasePage {
    public CarCardPage (WebDriver driver) {
        super(driver);
    }
    private final static String BASE_INFORMATION_LOCATOR_BY_XPATH =
            "//h3[contains(.,' Базовая информация')]";

    @FindBy(xpath = BASE_INFORMATION_LOCATOR_BY_XPATH)
    private WebElement BaseInformation;

    public void chekBaseInformation () {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                (BASE_INFORMATION_LOCATOR_BY_XPATH)));
        MatcherAssert.assertThat(driver.findElement(By.xpath("//h3")), hasText("Базовая информация"));

    }
}
