package HW6;

import HW7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;

public class parkomaticaTest {
    WebDriver driver;
    private final static String Parkomatica_URL = "https://cabinet.parkomatica.ru";

    @BeforeAll
    static void registrationDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get(Parkomatica_URL);
    }

    @DisplayName("Авторизвция")
    @Test
    public void authTest() {
        new LoginPage(driver).fillLogin("gbt@gbt.ru")
                .fillPassword("GBT")
                .clickLoginButton()
                .checkUrl();
    }

    @DisplayName("Добавление Авто")
    @Test
    public void addCarTest() {
        new LoginPage(driver).fillLogin("gbt@gbt.ru")
                .fillPassword("GBT")
                .clickLoginButton()
                .clickCarListButton()
                .ClickaddCarButton().fillCarNum("А381ВМ58")
                .clickDepartment()
                .clickAddCarButton()
                .chekBaseInformation();
    }

    @DisplayName("Проверка наличия авто")
    @Test
    public void carPresentInListTest() {
        new LoginPage(driver).fillLogin("gbt@gbt.ru")
                .fillPassword("GBT")
                .clickLoginButton()
                .clickCarListButton()
                .checkCarInList();
    }


    @AfterEach
    void killDriver() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logEntries.iterator();
        while (iterator.hasNext()) {
            Allure.addAttachment("Лог браузера", iterator.next().getMessage());
        }
        driver.quit();
    }

}
