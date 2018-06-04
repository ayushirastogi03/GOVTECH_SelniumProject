package AutomationTest.Pages.MyGrantsPage;

import AutomationTest.Pages.MyGrantsPage.GetNewGrant.ApplyForGrantPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrantActionsPage {

    private WebDriver driver;

    @FindBy(id = "keyPage-form-button")
    private WebElement ProceedButton;

    public GrantActionsPage(WebDriver driver)throws InterruptedException{
        this.driver=driver;
        navigateToGrantActionsPage();
        PageFactory.initElements(driver,this);
    }

    public void clickOnProceedButton(){
        ProceedButton.click();
    }

    public void navigateToGrantActionsPage() throws InterruptedException{
        ApplyForGrantPage applyforgrant=new ApplyForGrantPage(driver);
        applyforgrant.chooseBusinessArea();
        Thread.sleep(2000);
        applyforgrant.clickApplyButton();
    }
}
