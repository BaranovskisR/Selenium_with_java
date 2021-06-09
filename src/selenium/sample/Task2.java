package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.FeedBackPO;
import pageObject.GiveFeedBackPO;


public class Task2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedBackPO giveFeedBackPO;
    static FeedBackPO feedBackPO;


    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        giveFeedBackPO = PageFactory.initElements(driver, GiveFeedBackPO.class);
        feedBackPO = PageFactory.initElements(driver,FeedBackPO.class);
    }
    @After
    public void afterMethod() {
        driver.quit();
    }
    @Test
    public void initialFeedbackPage(){
        Assert.assertTrue(giveFeedBackPO.getName().isEmpty());
        Assert.assertTrue(giveFeedBackPO.getAge().isEmpty());
      for(int i =0; i <=3 ; i++){
          Assert.assertFalse(giveFeedBackPO.checkBoxStatus(i));
      }
        Assert.assertTrue(giveFeedBackPO.radioBtnStatus(2));
        Assert.assertEquals("Choose your option", giveFeedBackPO.checkDropDownStatus());
       String backgroundColor = giveFeedBackPO.submitBtn().getCssValue("background-color");
       Assert.assertEquals("rgba(33, 150, 243, 1)", backgroundColor);
       String letterColor = giveFeedBackPO.submitBtn().getCssValue("color");
       Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor);
    }
    @Test
    public void emptyFeedbackPage(){
        //Empty Field Check
        feedBackPO.button();
        Assert.assertEquals("",feedBackPO.getName());
        Assert.assertEquals("",feedBackPO.getAge());
        Assert.assertEquals("",feedBackPO.getLanguage());
        Assert.assertEquals("null",feedBackPO.getGender());
        Assert.assertEquals("null",feedBackPO.getOption());
        Assert.assertEquals("",feedBackPO.getComment());
        //Yes Button
        String backgroundColor = feedBackPO.yesBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", backgroundColor);
        String letterColor = feedBackPO.yesBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor);
        //No Button
        String backgroundColor2 = feedBackPO.noBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", backgroundColor2);
        String letterColor2 = feedBackPO.noBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor2);

    }
    @Test
    public void feedbackPage(){
        giveFeedBackPO.setName("abc");
        giveFeedBackPO.setAge("22");
        giveFeedBackPO.selectCheckBox(1);
        giveFeedBackPO.selectRadioBtn(2);
        giveFeedBackPO.dropDownBox("Ok, i guess");
        giveFeedBackPO.setComment("Hello!");

        feedBackPO.button();

        Assert.assertEquals("abc",feedBackPO.getName());
        Assert.assertEquals("22",feedBackPO.getAge());
        Assert.assertEquals("French",feedBackPO.getLanguage());
        Assert.assertEquals("null",feedBackPO.getGender());
        Assert.assertEquals("Ok, i guess",feedBackPO.getOption());
        Assert.assertEquals("Hello!",feedBackPO.getComment());
        //Yes Button
        String backgroundColor = feedBackPO.yesBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", backgroundColor);
        String letterColor = feedBackPO.yesBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor);
        //No Button
        String backgroundColor2 = feedBackPO.noBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", backgroundColor2);
        String letterColor2 = feedBackPO.noBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor2);
    }
}
