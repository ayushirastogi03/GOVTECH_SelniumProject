package AutomationTest.Pages.MyGrantsPage;

import AutomationTest.Pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class DashboardPage {
    private  WebDriver driver;

    public DashboardPage(WebDriver driver)throws InterruptedException{
        this.driver=driver;
        navigateToDashBoardPage();
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="dashboard-apply-icon")
    private  WebElement GetNewGrantIcon;


    public void clickOnGetNewGrant(){
        GetNewGrantIcon.click();
    }

    public void navigateToDashBoardPage()throws InterruptedException{
        LogInPage logInPage=new LogInPage(driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        logInPage.LoginAsDefinedUser("S9111111A");
    }

    public void navigateToSelectSectorPage() throws InterruptedException{

    }

}

