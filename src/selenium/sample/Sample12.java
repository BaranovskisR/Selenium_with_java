package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.AgePageAO;
import pageObject.AgeSubmittedPO;

public class Sample12 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static AgePageAO agePage;
    static AgeSubmittedPO ageSubmittedPO;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().window().maximize();
        agePage = PageFactory.initElements(driver, AgePageAO.class);
        ageSubmittedPO = PageFactory.initElements(driver, AgeSubmittedPO.class);
    }
    @After
    public void afterMethod() throws InterruptedException {
        //   Thread.sleep(2500);
        driver.quit();
    }
    //enter name & age- click submit
    @Test
    public void scenario1(){
        agePage.enterName("ABC");
        agePage.enterAge("40");
        agePage.submit();
        String actualMessage = ageSubmittedPO.getMsg();
        Assert.assertEquals("Hello, ABC, you are an adult", actualMessage);
    }
    @Test
    public void scenario2(){
        agePage.enterName("abc");
        agePage.submit();
        String actualMessage = agePage.errorMsg();
        Assert.assertEquals("You haven't entered anything in age field", actualMessage);
    }
    @Test
    public void scenario3(){
        agePage.enterAge("22");
        agePage.submit();
        String actualMessage = agePage.errorMsg();
        Assert.assertEquals("You haven't entered anything in name field", actualMessage);
    }
    @Test
    public void Scenario4(){
        agePage.enterName("ABC");
        agePage.enterAge("16");
        agePage.submit();
        String actualMessage = ageSubmittedPO.getMsg();
        Assert.assertEquals("Hello, ABC, you are a teenager", actualMessage);
    }
    @Test
    public void Scenario5(){
        agePage.enterName("ABC");
        agePage.enterAge("5");
        agePage.submit();
        String actualMessage = ageSubmittedPO.getMsg();
        Assert.assertEquals("Hello, ABC, you are a kid",actualMessage);
    }

}
