package pageObject;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedBackPO {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameTextBox;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageTextBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement submitBtn;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> radioBtn;

    @FindBy(how = How.ID,using = "like_us")
    private WebElement dropDownBox;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentBox;

    //Name
    public void setName(String name){
        nameTextBox.sendKeys(name);
    }
    public String getName(){
        return nameTextBox.getText();
    }

    //Age
    public void setAge(String age){
        ageTextBox.sendKeys(age);
    }
    public String getAge(){
        return ageTextBox.getText();
    }

    //CheckBox
    public boolean checkBoxStatus(int index){
        return checkBoxes.get(index).isSelected();
    }
    public void selectCheckBox(int index){
        checkBoxes.get(index).click();
    }

    //RadioBtn
    public boolean radioBtnStatus(int index){
        return radioBtn.get(index).isSelected();
    }
    public void selectRadioBtn(int index){
        radioBtn.get(index).click();
    }
    //DropDownBox
    public String checkDropDownStatus(){
        Select dropDownStatus = new Select(dropDownBox);
        return dropDownStatus.getFirstSelectedOption().getText();
    }
    public void dropDownBox(String option){
        Select dropDown = new Select(dropDownBox);
        dropDown.selectByVisibleText(option);
    }
    //Comment
    public void setComment(String comment) {
        commentBox.sendKeys(comment);
    }
    public String getComment()
    {
        return commentBox.getText();
    }
    //Submit
    public WebElement submitBtn()
    {
        return submitBtn;
    }

}
