package AutomationTest.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogInPage {

    private WebDriver driver;

    @FindBy(xpath="//form[1]/button")
    WebElement LoginButton;

    @FindBy(xpath="//div[@class='base-container']//select")
    WebElement ListOfUsers;

    public LogInPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public LogInPage(WebDriver driver,boolean autoload){
        this.driver=driver;
        navigateToLoginPage();
        PageFactory.initElements(driver,this);
    }

    public void LoginAsDefinedUser(String userId)throws InterruptedException{
        ListOfUsers.click();
        Select selectUser=new Select(ListOfUsers);
        List<WebElement> optionList=selectUser.getOptions();
        int elementIndex=0;
        for(WebElement element:optionList){
            if(element.getText().equalsIgnoreCase("S9111111A - 197702066M")){
                elementIndex=optionList.indexOf(element);
                break;
            }
        }
        selectUser.getOptions().get(elementIndex).click();
        Thread.sleep(1000);
        LoginButton.click();
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    }

    public void navigateToLoginPage(){
        HomePage homePage=new HomePage(driver,true);
        homePage.validateHomePageUrl();
        homePage.clickOnLoginButton();
    }

}
