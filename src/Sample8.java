
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample8 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }

    @Test
    public void verifyFontSize()
    {
//        WebElement element1 = driver.findElement(By.cssSelector("p.w3-deep-purple"));
//        String actualFontSize = element1.getCssValue("font-size");
//        Assert.assertEquals("15px", actualFontSize);
//        System.out.println(element1.getCssValue("font-family"));
//        System.out.println(element1.getCssValue("background-color"));
//        Assert.assertEquals("rgba(103, 58, 183, 1)",element1.getCssValue("background-color") );
//        System.out.println(element1.getCssValue("padding-left"));
    }

    @Test
    public void verifyBackgroundColor()
    {
        WebElement luckParagraph7Label = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
        String actualValue = luckParagraph7Label.getCssValue("background-color");
        Assert.assertEquals("rgba(233, 30, 99, 1)", actualValue);
    }
    @Test
    public void paragraph2()
    {
        WebElement element1 = driver.findElement(By.cssSelector("p.w3-green"));
        String actualFontSize = element1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element1.getCssValue("font-family"));
        System.out.println(element1.getCssValue("background-color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)", element1.getCssValue("background-color"));
        Assert.assertEquals("Verdana, sans-serif", element1.getCssValue("font-family"));
    }
    @Test
    public void paragraph1()
    {
        WebElement element1 = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualFontSize = element1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element1.getCssValue("font-family"));
        System.out.println(element1.getCssValue("background-color"));
        Assert.assertEquals("rgba(0, 0, 0, 0)", element1.getCssValue("background-color"));
        Assert.assertEquals("Verdana, sans-serif", element1.getCssValue("font-family"));
    }
    @Test
    public void paragraph4()
    {
        WebElement element1 = driver.findElement(By.cssSelector("p.crazy"));
        String actualFontSize = element1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element1.getCssValue("font-family"));
        System.out.println(element1.getCssValue("background-color"));
        Assert.assertEquals("rgba(103, 58, 183, 1)", element1.getCssValue("background-color"));
        Assert.assertEquals("Verdana, sans-serif", element1.getCssValue("font-family"));
    }
    @Test
    public void paragraph6()
    {
        WebElement element1 = driver.findElement(By.xpath("//p[@id = 'cool']"));
        String actualFontSize = element1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element1.getCssValue("font-family"));
        System.out.println(element1.getCssValue("background-color"));
        Assert.assertEquals("rgba(33, 150, 243, 1)", element1.getCssValue("background-color"));
        Assert.assertEquals("Verdana, sans-serif", element1.getCssValue("font-family"));
    }
    @Test
    public void paragraph7()
    {
        WebElement element1 = driver.findElement(By.cssSelector("p.w3-pink"));
        String actualFontSize = element1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element1.getCssValue("font-family"));
        System.out.println(element1.getCssValue("background-color"));
        Assert.assertEquals("rgba(233, 30, 99, 1)", element1.getCssValue("background-color"));
        Assert.assertEquals("Verdana, sans-serif", element1.getCssValue("font-family"));
    }
    @Test
    public void browserFunctionalities() throws InterruptedException {
        Thread.sleep(2500);
        driver.navigate().to("https://kristinek.github.io/site/examples/locators");
        Thread.sleep(2500);
        driver.navigate().back();
        Thread.sleep(2500);
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.navigate().forward();
        Thread.sleep(2500);
        driver.navigate().refresh();
    }
    @Test
    public void browserFunctionalities2() throws InterruptedException {
        driver.navigate().to("https://kristinek.github.io/site/examples/sync");
        Thread.sleep(2500);
        driver.manage().window().maximize();
        driver.navigate().back();
        Thread.sleep(2500);
        driver.navigate().forward();
        Thread.sleep(2500);
        driver.navigate().refresh();
        driver.quit();
    }
}