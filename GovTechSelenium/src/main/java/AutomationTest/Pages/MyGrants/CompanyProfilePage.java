package AutomationTest.Pages.MyGrants;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CompanyProfilePage {
//we get the application ID on this page
    //assertion - we can check the out put on this page with the values we have entered as a check point
    private WebDriver driver;

    public CompanyProfilePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @FindBy(xpath="//input[@id='react-declaration-info_truthfulness_check']")
    private WebElement checkBox;

    @FindBy(id="submit-btn")
    private WebElement submitButton;

    public void agreement() throws InterruptedException{
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        checkBox.click();
        if(submitButton.isEnabled()){
            submitButton.click();
        }
    }




}
