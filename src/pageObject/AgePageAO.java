package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePageAO {

    @FindBy(how = How.NAME, using = "name")
    private WebElement nameTextBox;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageTextBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Submit']")
    private WebElement submitBtn;

    @FindBy(how = How.CSS, using = "p.error")
    private WebElement errorMsg;


    public void enterName(String name){
        nameTextBox.clear();
        nameTextBox.sendKeys(name);
    }
    public void enterAge(String age){
        ageTextBox.sendKeys(age);
    }
    public void submit(){
        submitBtn.click();
    }
    public String errorMsg(){
        return errorMsg.getText();
    }
}
