package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {

        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/locators");

        Thread.sleep(1000);
// By id
        System.out.println(driver.findElement(By.id("heading_1")).getText());
// By Name
        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("value"));
// By Class name
        System.out.println(driver.findElement(By.className("twoTest")).getText());
// By Tag list
        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println(pTag.size());
        System.out.println(pTag.get(5).getText());
        System.out.println(pTag.get(6).getText());
        System.out.println(pTag.get(7).getText());

        driver.quit();
    }
}