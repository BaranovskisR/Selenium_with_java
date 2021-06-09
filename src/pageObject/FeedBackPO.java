package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPO {
    @FindBy(how = How.ID,using = "name")
    private WebElement name;
    @FindBy(how = How.ID,using = "age")
    private WebElement age;
    @FindBy(how = How.ID,using = "language")
    private WebElement language;
    @FindBy(how = How.ID,using = "gender")
    private WebElement gender;
    @FindBy(how = How.ID,using = "option")
    private WebElement option;
    @FindBy(how = How.ID,using = "comment")
    private WebElement comment;
    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement send;
    @FindBy(how = How.XPATH,using = "//button[text()='Yes']")
    private WebElement yesBtn;
    @FindBy(how = How.XPATH,using = "//button[text()='No']")
    private WebElement noBtn;

    public String getName(){
        return name.getText();
    }
    public String getAge(){
        return age.getText();
    }
    public String getLanguage(){
        return language.getText();
    }
    public String getGender(){
        return gender.getText();
    }
    public String getOption(){
        return option.getText();
    }
    public String getComment(){
        return comment.getText();
    }
    public void button(){
        send.click();
    }
    public WebElement yesBtn(){
        return yesBtn;
    }
    public WebElement noBtn(){
        return noBtn;
    }

}
