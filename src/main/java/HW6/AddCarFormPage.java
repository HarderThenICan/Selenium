package HW6;

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

    @FindBy (xpath = "//li[text() = 'GBT']")
    private WebElement targetDepartment;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement addCarButton;


    public AddCarFormPage fillCarNum(String carNum) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CarFormCreate[carNum]']")));
        carNumForm.sendKeys(carNum);
        return this;
    }

    public AddCarFormPage clickDepartment() {
        departmentForm.click();
        targetDepartment.click();
        return this;
    }
    public CarCardPage clickAddCarButton() {
        addCarButton.click();
        return new CarCardPage(driver);
    }


}
