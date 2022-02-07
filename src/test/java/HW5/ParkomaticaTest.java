package HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;

public class ParkomaticaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String Parkomatica_URL = "https://cabinet.parkomatica.ru";

    @BeforeAll
    static void driverRegister() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(Parkomatica_URL);
    }

    @DisplayName("Авторизвция")
    @Test
    void auth() {
        driver.findElement(By.xpath("//*[@id='loginform-email']")).sendKeys("gbt@gbt.ru");
        driver.findElement(By.xpath("//input[@id='loginform-password']")).sendKeys("GBT");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fa fa-money-bill bg-gray']")));
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals("https://cabinet.parkomatica.ru/info", URL);
    }


    @DisplayName("Добавление авто")
    @Test
    public void addAuto() {
        driver.findElement(By.xpath("//*[@id='loginform-email']")).sendKeys("gbt@gbt.ru");
        driver.findElement(By.xpath("//input[@id='loginform-password']")).sendKeys("GBT");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fa fa-car']")));
        driver.findElement(By.xpath("//*[@class='fa fa-car']")).click();
        driver.findElement(By.xpath("//*[@class='text-right']/a[@href='/car/create']")).click();
        driver.findElement(By.xpath("//input[@name='CarFormCreate[carNum]']")).sendKeys("B132НА11");
        driver.findElement(By.xpath("//span[@id='select2-carformcreate-organizationid-container']")).click();
        driver.findElement(By.xpath("//li[text() = 'GBT']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h3[contains(.,' Базовая информация')]")));
        MatcherAssert.assertThat(driver.findElement(By.xpath("//h3")), hasText("Базовая информация"));
    }
    @DisplayName("Проверка наличия авто")
    @Test
    void carPresentInList() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='loginform-email']")).sendKeys("gbt@gbt.ru");
        driver.findElement(By.xpath("//input[@id='loginform-password']")).sendKeys("GBT");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'автомобилей')]")));
        driver.findElement(By.xpath("//a[contains(text(),'автомобилей')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='box-body']")));
        MatcherAssert.assertThat(driver.findElement(By.xpath("//a[contains(@href, '/car/view?id=152299')]")),hasText("а111аа01"));
    }

    @AfterEach
    void tearDown() {

        driver.quit();
    }
}
