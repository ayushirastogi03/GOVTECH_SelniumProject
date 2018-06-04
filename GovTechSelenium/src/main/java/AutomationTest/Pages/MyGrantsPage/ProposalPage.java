package AutomationTest.Pages.MyGrantsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProposalPage {

    private WebDriver driver;

    public ProposalPage(WebDriver driver)throws InterruptedException{
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProposalPage(WebDriver driver,boolean autoload)throws InterruptedException{
        this.driver = driver;
        navigateToProposalPage();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),\"ProposalPage\")]")
    private WebElement proposal;

    @FindBy(xpath = "//span[@id='react-select-project-psg_solution_id--value']//input[@role=\"combobox\"]")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@id='react-project-start_date']")
    private WebElement calendarIcon;

    @FindBy(xpath = "//div[7]//span[contains(text(),'Yes')]")
    private WebElement checkExistingSolution;

    @FindBy(xpath = "//div[@class='Select Select--single is-searchable has-value']//span[@class='Select-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//textarea[@id='react-project-reason_for_engagement']")
    private WebElement reason;

    @FindBy(xpath = "//span[@id='react-select-project-vendors-0-selected_value--value']//input[@role='combobox']")
    private WebElement vendorList;

    @FindBy(xpath = "//div/button[@id='react-project-vendors-0-attachments-btn']")
    private WebElement selectFiles;

    @FindBy(xpath = "//span[@id='react-select-project-locations-0-location_type--value']//input[@role='combobox']")
    private WebElement locationType;

    @FindBy(xpath = "//div[@class='col-sm-8']//input[@id=\"react-project-locations-0-postal\"]")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='react-project-locations-0-business_operation_check-true']/following-sibling::span[@class='radiobutton']")
    private WebElement checkBusinessAddress;

    @FindBy(id = "next-btn")
    public WebElement NextButton;

    @FindBy(xpath="//input[@type='file']")
    private WebElement uploadFileLink;

    @FindBy(xpath="//span[@id='react-select-project-vendors-0-attachments-0-document_type-types--value']//input[@role='combobox']")
    private WebElement typeOfDocumentDropDown;

    public void selectTypeOfSolution() {
        List<WebElement> radibuttons = driver.findElements(By.xpath("//label[@class='bgp-radio']"));
        WebElement ItSolutionRadioButton = radibuttons.get(1);
        ItSolutionRadioButton.click();
    }

    public void searchSolution(String builderSolution) {
        searchBox.sendKeys(builderSolution);
        searchBox.sendKeys(Keys.TAB);
    }

    public void setDate() {
        calendarIcon.sendKeys("05 Jun 2018");
        checkExistingSolution.click();
        reason.sendKeys("test");
    }

    public void selectVendorList() {
        vendorList.sendKeys("IT Infinity Pte Ltd 123");
        vendorList.sendKeys(Keys.TAB);
    }

    public void uploadTestFile()throws InterruptedException{
        File f = new File("src/main/resources/TESTFile.doc");
        uploadFileLink.sendKeys(f.getAbsolutePath());
        Thread.sleep(4000);
        typeOfDocumentDropDown.sendKeys("Selected vendor");
        typeOfDocumentDropDown.sendKeys(Keys.TAB);
    }

    public void enterLocationType(String typeOfLocation) throws InterruptedException{
        locationType.sendKeys(typeOfLocation);
        Thread.sleep(2000);
        locationType.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        postalCode.sendKeys("509063");
        Thread.sleep(2000);
        checkBusinessAddress.click();
        NextButton.click();
    }

    public void navigateToProposalPage() throws InterruptedException{
        ContactDetailsPage contactDetailsPage=new ContactDetailsPage(driver,true);
        contactDetailsPage.enterContactDetails("test","test",12345678,"abc@test.com","abc1@test.com");
        contactDetailsPage.provideMailingAddress();
        boolean check=contactDetailsPage.checkOfferAddresseDetails();
        contactDetailsPage.clickNext(check);
    }

}



