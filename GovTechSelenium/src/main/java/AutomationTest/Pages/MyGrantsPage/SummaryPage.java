package AutomationTest.Pages.MyGrantsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {

    private WebDriver driver;

    @FindBy(xpath="//h3[contains(text(),'Your application has been successfully submitted')]")
    private WebElement successMessage;

    public SummaryPage(WebDriver driver)throws InterruptedException{
        this.driver=driver;
        navigateToSummaryPage();
        PageFactory.initElements(driver,this);
    }

    public boolean  checkSuccessMessage(){
        boolean checkMessage=false;
        if(successMessage.isDisplayed()){
            checkMessage=true;
        }
        return checkMessage;
    }

    public void navigateToSummaryPage() throws InterruptedException{
        CompanyProfilePage companyProfilePage=new CompanyProfilePage(driver);
        companyProfilePage.agreement();
    }
}
