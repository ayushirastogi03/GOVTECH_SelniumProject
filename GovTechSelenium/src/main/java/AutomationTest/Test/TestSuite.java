package AutomationTest.Test;

import AutomationTest.Pages.MyGrantsPage.*;
import AutomationTest.Pages.LogInPage;
import AutomationTest.Pages.MyGrantsPage.GetNewGrant.ApplyForGrantPage;
import AutomationTest.Pages.MyGrantsPage.GetNewGrant.SelectGrantPage;
import AutomationTest.Pages.MyGrantsPage.GetNewGrant.SelectSectorPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestSuite {

   public  WebDriver driver;

    public void setDriverToChromeDriver(){
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        System.setProperty("webdriver.chrome.driver","/Users/ayushirastogi/Downloads/googlechrome.dmg");
    }

    @Test
    public void sampletestcase1()throws InterruptedException{
        setDriverToChromeDriver();
        driver.navigate().to("https://public:Let$BeC001@bgp-qa.gds-gov.tech");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        SummaryPage summaryPage=new SummaryPage(driver);
        summaryPage.checkSuccessMessage();
    }

    @Test
    public void testCase1() throws InterruptedException{
        setDriverToChromeDriver();
        driver.navigate().to("https://public:Let$BeC001@bgp-qa.gds-gov.tech");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        LogInPage logInPage=new LogInPage(driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        try{
            logInPage.LoginAsDefinedUser("S9111111A");
        }
        catch(Exception e){
            System.out.println(e);
        }
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.clickOnGetNewGrant();

        SelectSectorPage selectSectorPage =new SelectSectorPage(driver);
        selectSectorPage.selectSector();

        SelectGrantPage selectGrantPage =new SelectGrantPage(driver);
        selectGrantPage.selectGrant();

        ApplyForGrantPage applyforgrant=new ApplyForGrantPage(driver);
        applyforgrant.chooseBusinessArea();
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println(e);
        }
        applyforgrant.clickApplyButton();

        GrantActionsPage grantActionsPage=new GrantActionsPage(driver);
        grantActionsPage.clickOnProceedButton();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        try{
            Thread.sleep(10000);
        }
        catch(Exception e){
            System.out.println(e);
        }

        EligibilityPage eligibilityPage=new EligibilityPage(driver);

        Assert.assertFalse("All Elements are enabled",eligibilityPage.selectYesRadioButton());
        Assert.assertTrue("Next Button is Enabled",eligibilityPage.nextButtonEnabled());
        eligibilityPage.clickOnNextButton();
        try{Thread.sleep(1000);}
            catch(Exception e){
            System.out.println(e);
        }
        ContactDetailsPage contactDetailsPage=new ContactDetailsPage(driver);
        contactDetailsPage.enterContactDetails("test","test",12345678,"abc@test.com","abc1@test.com");
        contactDetailsPage.provideMailingAddress();
        boolean check=contactDetailsPage.checkOfferAddresseDetails();
        contactDetailsPage.clickNext(check);

        ProposalPage proposalPage=new ProposalPage(driver);
        proposalPage.selectTypeOfSolution();
        proposalPage.searchSolution("Product Solutions");
        proposalPage.setDate();
        proposalPage.selectVendorList();
        proposalPage.uploadTestFile();
        proposalPage.enterLocationType("Home Office/Residential Building");

        CostPage costPage=new CostPage(driver);
        costPage.selectPurchaseType();

        BusinessImpactPage businessImpactPage=new BusinessImpactPage(driver);
        businessImpactPage.provideBusinessImpact();

        DeclareReviewPage declareReviewPage=new DeclareReviewPage(driver);
        declareReviewPage.provideAnswers();

        CompanyProfilePage companyProfilePage=new CompanyProfilePage(driver);
        companyProfilePage.agreement();

        SummaryPage summaryPage=new SummaryPage(driver);
        summaryPage.checkSuccessMessage();

    }

    @Test
    public void testCase2() throws InterruptedException{
        EligibilityPage eligibilityPage=new EligibilityPage(driver);
        boolean validation=eligibilityPage.selectNoRadioButton();
        Assert.assertTrue("All elements are disabled",validation);
        if(validation){
            Assert.assertTrue("SME Link is Enabled",eligibilityPage.smeMattersLinkEnabled());
            Assert.assertFalse("Next Button Disabled",eligibilityPage.nextButtonEnabled());
        }
    }

}
