package org.selenium.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumBase {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); - пробовал разные варианты  =)
        driver.get("https://cabinet.parkomatica.ru");
        driver.findElement(By.xpath("//*[@id='loginform-email']")).sendKeys("gbt@gbt.ru");
        driver.findElement(By.xpath("//input[@id='loginform-password']")).sendKeys("GBT");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fa fa-car']")));
        driver.findElement(By.xpath("//*[@class='fa fa-car']")).click();
        driver.findElement(By.xpath("//*[@class='text-right']/a[@href='/car/create']")).click();
        driver.findElement(By.xpath("//input[@name='CarFormCreate[carNum]']")).sendKeys("А998НА99");
        driver.findElement(By.xpath("//span[@id='select2-carformcreate-organizationid-container']")).click();
        driver.findElement(By.xpath("//li[text() = 'GBT']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,' Базовая информация')]")));
        driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).click();
        Thread.sleep(5000); //Жду просто чтобы увидеть, что разлогинился =)
      //  driver.quit();
    }
}
