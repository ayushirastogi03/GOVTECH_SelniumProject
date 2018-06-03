package AutomationTest.Pages.MyGrants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {

    private WebDriver driver;

    @FindBy(xpath="//h3[contains(text(),'Your application has been successfully submitted')]")
    private WebElement successMessage;

    public SummaryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean  checkSuccessMessage(){
        boolean checkMessage=false;
        if(successMessage.isDisplayed()){
            checkMessage=true;
        }
        return checkMessage;
    }
}
