package AutomationTest.Pages.MyGrants.GetNewGrant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectGrant {
    private WebDriver driver;

    @FindBy(xpath="//div[contains(text(),\"Upgrade\")]")
    private WebElement selectGrant;

        public SelectGrant(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        }

        public void selectGrant() {
        selectGrant.click();
        }


}
