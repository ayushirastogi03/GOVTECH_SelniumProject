package AutomationTest.Pages.MyGrants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrantActionsPage {

    private WebDriver driver;


    @FindBy(id = "keyPage-form-button")
    private WebElement ProceedButton;
        public GrantActionsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        }
        public void clickOnProceedButton(){
        ProceedButton.click();
        }
}
