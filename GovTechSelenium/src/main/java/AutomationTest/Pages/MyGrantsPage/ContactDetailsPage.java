package AutomationTest.Pages.MyGrantsPage;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

//Negative Test : Functional validations : altemail and email add cannot be the same.
//when you check the checkbOX - everything is autopopulated
//letterof offer addresses - if you check the check box - the name , job Ttile, email is autopopulated.
// There can be two test cases - one with autopopulated and the other with no autopopulation.( covered # here with Autopopulation )

public class ContactDetailsPage {

    private WebDriver driver;

    public ContactDetailsPage(WebDriver driver) throws InterruptedException{
        this.driver=driver;
        navigateToContactDetailsPage();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[contains(text(),\"Contact Details\")]")
    private WebElement contactDetails;

    @FindBy(id="react-contact_info-name")
    private WebElement nameTextBox;

    @FindBy(id="react-contact_info-designation")
    private WebElement jobTitleTextBox;

    @FindBy(id="react-contact_info-phone")
    private WebElement contactNoTextBox;

    @FindBy(id="react-contact_info-primary_email")
    private WebElement emailTextBox;

    @FindBy(id="react-contact_info-secondary_email")
    private WebElement alternateEmailTextBox;

    @FindBy(xpath = "//input[@id='react-contact_info-correspondence_address-copied']")
    private WebElement mailingAddressCheckbox;

    @FindBy(id="react-contact_info-correspondence_address-postal")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='react-contact_info-copied']")
    private WebElement letterOfOfferAddresse;

    @FindBy(id="react-contact_info-offeree_name")
    private WebElement nameOfferee;

    @FindBy(id="react-contact_info-offeree_designation")
    private WebElement offereeDesignation;

    @FindBy(id="react-contact_info-offeree_email")
    private WebElement offereeEmailid;

    @FindBy(id="next-btn")
    private WebElement nextButton;


    public void enterContactDetails(String name, String JobTitle, long contactNum, String Emailid , String altEmailId){
        nameTextBox.sendKeys(name);
        jobTitleTextBox.sendKeys(JobTitle);
        contactNoTextBox.sendKeys(String.valueOf(contactNum));
        emailTextBox.sendKeys(Emailid);
        alternateEmailTextBox.sendKeys(altEmailId);
    }

    public boolean provideMailingAddress(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        mailingAddressCheckbox.click();
        return postalCode.getAttribute("value").equalsIgnoreCase(String.valueOf(453123));
    }

    public boolean checkOfferAddresseDetails(){
        boolean checkDetails =false;
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        letterOfOfferAddresse.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        if((nameOfferee.getAttribute("value").equalsIgnoreCase(nameTextBox.getAttribute("value")))
                &&(offereeDesignation.getAttribute("value").equalsIgnoreCase(jobTitleTextBox.getAttribute("value")))
                &&(offereeEmailid.getAttribute("value").equalsIgnoreCase(emailTextBox.getAttribute("value")))){
            checkDetails=true;
        }
        return checkDetails;
    }

    public void clickNext(boolean check){
        if(check){
            nextButton.click();
        }
    }

    public void navigateToContactDetailsPage() throws InterruptedException{
        EligibilityPage eligibilityPage=new EligibilityPage(driver);
        eligibilityPage.selectYesRadioButton();
        eligibilityPage.clickOnNextButton();
        Thread.sleep(2000);
    }

}
