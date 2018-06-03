package AutomationTest.Pages.MyGrants.GetNewGrant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ApplyForGrant {

    private WebDriver driver;

    @FindBy(xpath="//div[contains(text(),\"Pre-scoped\")]")
    private WebElement chooseBusinessArea;

    @FindBy(id="go-to-grant")
    private WebElement applyButton;

        public ApplyForGrant(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        }

        public void chooseBusinessArea() {
            chooseBusinessArea.click();
        }
        public void clickApplyButton(){
            applyButton.click();
        }

}
