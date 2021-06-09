package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmittedPO {

    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private WebElement button;

    public String getMsg(){
        return message.getText();
    }
    public void button(){
        button.click();
    }


}
