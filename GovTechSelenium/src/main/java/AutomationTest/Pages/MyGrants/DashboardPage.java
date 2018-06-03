package AutomationTest.Pages.MyGrants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DashboardPage {
    private  WebDriver driver;

        public DashboardPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

    @FindBy(className="dashboard-apply-icon")
    private  WebElement GetNewGrantIcon;


        public void clickOnGetNewGrant(){
            GetNewGrantIcon.click();
        }



}

