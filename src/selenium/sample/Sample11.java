package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample11 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        //   Thread.sleep(2500);
        driver.quit();
    }
@Test
    public void clickOnGreedBtn()
{
    WebElement greenBtn = driver.findElement(By.id("start_green"));
    greenBtn.click();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish_green")));
}
@Test
    public void clickOnTealBtn()
{
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_green_and_blue")));
    WebElement tealBtn = driver.findElement(By.id("start_green_and_blue"));
    tealBtn.click();
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish_green_and_blue")));
}
}
