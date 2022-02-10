package HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddCarFormPage extends BasePage {
    public AddCarFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='CarFormCreate[carNum]']")
    private WebElement carNumForm;

    @FindBy(xpath = "//span[@id='select2-carformcreate-organizationid-container']")
    private WebElement departmentForm;

    @FindBy(xpath = "//li[text() = 'GBT']")
    private WebElement targetDepartment;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addCarButton;


    @Step("Заполнение формы номера авто")
    public AddCarFormPage fillCarNum(String carNum) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CarFormCreate[carNum]']")));
        carNumForm.sendKeys(carNum);
        return this;
    }

    @Step("Клик на форму выбора департамента")
    public AddCarFormPage clickDepartment() {
        departmentForm.click();
        targetDepartment.click();
        return this;
    }

    @Step("Клик на кнопку добавления автомобиля")
    public CarCardPage clickAddCarButton() {
        addCarButton.click();
        return new CarCardPage(driver);
    }


}
