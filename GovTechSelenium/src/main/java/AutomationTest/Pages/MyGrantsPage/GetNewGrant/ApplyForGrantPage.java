package AutomationTest.Pages.MyGrantsPage.GetNewGrant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyForGrantPage {

    private WebDriver driver;

    @FindBy(xpath="//div[contains(text(),\"Pre-scoped\")]")
    private WebElement chooseBusinessArea;

    @FindBy(id="go-to-grant")
    private WebElement applyButton;

    public ApplyForGrantPage(WebDriver driver)throws InterruptedException{
        this.driver=driver;
        navigateToApplyForGrantPage();
        PageFactory.initElements(driver,this);
    }

    public void chooseBusinessArea() {
        chooseBusinessArea.click();
    }

    public void clickApplyButton(){
        applyButton.click();
    }

    public void navigateToApplyForGrantPage() throws InterruptedException{
        SelectGrantPage selectGrantPage =new SelectGrantPage(driver);
        selectGrantPage.selectGrant();
    }
}
