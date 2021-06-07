package selenium.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    @Before
    public void beforeMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @Test
    public void errorOnNumberTooSmall(){
        WebElement field = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        field.sendKeys("22");
        submit.click();
        WebElement message = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too small";
        String actualValue = message.getText();
        Assert.assertEquals(expectedValue, actualValue);

        driver.quit();
    }
    @Test
    public void errorOnNumberTooBig(){
        WebElement field = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        field.sendKeys("165");
        submit.click();
        WebElement message = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too big";
        String actualValue = message.getText();
        Assert.assertEquals(expectedValue, actualValue);

        driver.quit();
    }
    @Test
    public void correctSquareRootWithoutRemainder(){
        WebElement field = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        field.sendKeys("81");
        submit.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Square root of 81 is 9.00", alert.getText());
        alert.accept();

        driver.quit();
    }
    @Test
    public void correctSquareRootWithRemainder() {
        WebElement field = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        field.sendKeys("70");
        submit.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Square root of 70 is 8.37", alert.getText());
        alert.accept();

        driver.quit();
    }
}
