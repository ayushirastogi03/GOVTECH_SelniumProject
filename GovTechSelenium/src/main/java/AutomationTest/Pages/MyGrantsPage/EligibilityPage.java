package AutomationTest.Pages.MyGrantsPage;


import javafx.scene.control.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class EligibilityPage {

    private WebDriver driver;

    @FindBy(xpath="//span[contains(text(),\"No\")]")
    private RadioButton nO;

    @FindBy(partialLinkText = "Smart Advisor")
    WebElement smeMattersLink;

    @FindBy(xpath="//span[contains(text(),\"Contact Details\")]")
    private WebElement contactDetails;

    @FindBy(xpath="//span[contains(text(),\"ProposalPage\")]")
    private WebElement proposal;

    @FindBy(xpath="//span[contains(text(),\"CostPage\")]")
    private WebElement cost;

    @FindBy(xpath="//span[contains(text(),\"Business Impact\")]")
    private WebElement businessImpact;

    @FindBy(xpath="//span[contains(text(),\"Declare & Review\")]")
    private WebElement declareReview;

    @FindBy(id="next-btn")
    private WebElement nextButton;

    public EligibilityPage(WebDriver driver)throws InterruptedException{
        this.driver=driver;
        navigateToEligbilityPage();
        PageFactory.initElements(driver,this);
    }

    public boolean selectYesRadioButton(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        List<WebElement> radiobuttons=driver.findElements(By.xpath("//span[@class='bgp-label']"));
        radiobuttons.get(0).click();
        System.out.println(radiobuttons.get(0).isSelected());
        return validateAllOtherWebElementsEnabled();
    }

    public void clickOnNextButton(){
        nextButton.click();
    }

    public boolean selectNoRadioButton() {
        nO.onMouseClickedProperty();
        return  validateAllOtherWebElementsEnabled();
    }

    public boolean  smeMattersLinkEnabled(){
        return smeMattersLink.isEnabled();
    }

    public boolean nextButtonEnabled(){
        return nextButton.isEnabled();
    }

    public boolean validateAllOtherWebElementsEnabled() {
        boolean checkElementsEnabled =false;
        if((!contactDetails.isEnabled())&&(!proposal.isEnabled())&&(!cost.isEnabled())
                &&(!businessImpact.isEnabled())&&(!declareReview.isEnabled())){
            checkElementsEnabled = true;
        }
        return checkElementsEnabled;
    }

    public void navigateToEligbilityPage() throws InterruptedException{
        GrantActionsPage grantActionsPage=new GrantActionsPage(driver);
        grantActionsPage.clickOnProceedButton();
        Thread.sleep(2000);
    }

}

