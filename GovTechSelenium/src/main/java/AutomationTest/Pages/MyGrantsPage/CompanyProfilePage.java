package AutomationTest.Pages.MyGrantsPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CompanyProfilePage {
    private WebDriver driver;

    public CompanyProfilePage(WebDriver driver)throws InterruptedException{
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public CompanyProfilePage(WebDriver driver,boolean autoload)throws InterruptedException{
        this.driver=driver;
        navigateToCompanyProfilePage();
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

    public void navigateToCompanyProfilePage() throws InterruptedException{
        DeclareReviewPage declareReviewPage=new DeclareReviewPage(driver,true);
        declareReviewPage.provideAnswers();
    }

}
