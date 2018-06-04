package stepDef;

import AutomationTest.Pages.HomePage;
import AutomationTest.Pages.LogInPage;
import AutomationTest.Pages.MyGrantsPage.*;
import AutomationTest.Pages.MyGrantsPage.GetNewGrant.ApplyForGrantPage;
import AutomationTest.Pages.MyGrantsPage.GetNewGrant.SelectGrantPage;
import AutomationTest.Pages.MyGrantsPage.GetNewGrant.SelectSectorPage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ExcelFileReader;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StepDef {

    private WebDriver driver;

    @Given("^Launch chrome driver$")
    public void launch_chrome_driver()  {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen( );
        driver.manage().deleteAllCookies();
    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^Launch application url$")
    public void launch_application_url()  {
        driver.navigate().to("https://public:Let$BeC001@bgp-qa.gds-gov.tech"  );
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @Then("^Submit a grant and Validate the grant is submitted successfully on Summary Page$")
    public void validate_the_grant_is_submitted_successfully_on_Summary_Page() throws InterruptedException {
        SummaryPage summaryPage=new SummaryPage(driver,true);
        summaryPage.checkSuccessMessage( );
    }
    @Given("^Sign In the user with valid credentials to launch the application$")
    public void sign_In_the_user_with_valid_credentials_to_launch_the_application()   {
        driver.navigate().to("https://public:Let$BeC001@bgp-qa.gds-gov.tech");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @Given("^Login with  a predefined User$")
    public void login_with_a_predefined_User() throws Exception {
        HomePage homePage=new HomePage(driver);
        homePage.validateHomePageUrl();
        homePage.clickOnLoginButton();
        LogInPage logInPage=new LogInPage(driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        logInPage.LoginAsDefinedUser("S9111111A");
    }

    @When("^Apply for Grant$")
    public void apply_for_Grant() throws InterruptedException {

        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.clickOnGetNewGrant();

        SelectSectorPage selectSectorPage =new SelectSectorPage(driver);
        selectSectorPage.selectSector();

        SelectGrantPage selectGrantPage =new SelectGrantPage(driver);
        selectGrantPage.selectGrant();

        ApplyForGrantPage applyforgrant=new ApplyForGrantPage(driver);
        applyforgrant.chooseBusinessArea();
        Thread.sleep(1000);

        applyforgrant.clickApplyButton();

        GrantActionsPage grantActionsPage=new GrantActionsPage(driver);
        grantActionsPage.clickOnProceedButton();

        Thread.sleep(10000);
    }

    @When("^Provide confirmation on Eligibility and validate all tabs get enabled$")
    public void provide_confirmation_on_Eligibility() throws InterruptedException{
        EligibilityPage eligibilityPage=new EligibilityPage(driver);

        Assert.assertFalse("All Elements are enabled",eligibilityPage.selectYesRadioButton());
        Assert.assertTrue("Next Button is Enabled",eligibilityPage.nextButtonEnabled());

        eligibilityPage.clickOnNextButton();

        Thread.sleep(1000);
    }


    @When("^Provide Contact Details on the Contact & Details page$")
    public void provide_Contact_Details_on_the_Contact_Details_page(DataTable dataTable) throws Exception  {
        Map<String,String> dataMap=dataTable.asMap(String.class,String.class);

        ExcelFileReader excelFileReader=new ExcelFileReader("src/test/resources/testData/TestData.xls");
        List<String> testDataList=excelFileReader.getTestCaseDataAsList(dataMap.get("testcase_ID"));

        String name=testDataList.get(1);
        String JobTitle=testDataList.get(2);
        String ContactNum=testDataList.get(3);
        String EmailId=testDataList.get(4);
        String AltEmailId=testDataList.get(5);

        ContactDetailsPage contactDetailsPage=new ContactDetailsPage(driver);
        contactDetailsPage.enterContactDetails(name,JobTitle,Long.valueOf(ContactNum),EmailId,AltEmailId);
        contactDetailsPage.provideMailingAddress();
        boolean check=contactDetailsPage.checkOfferAddresseDetails();
        contactDetailsPage.clickNext(check);
    }

    @When("^Provide type of solution, date , vendor list, location type and upload the testfile$")
    public void provide_type_of_solution_date_vendor_list_location_type_and_upload_the_testfile()  throws InterruptedException {
        ProposalPage proposalPage=new ProposalPage(driver);
        proposalPage.selectTypeOfSolution();
        proposalPage.searchSolution("Product Solutions");
        proposalPage.setDate();
        proposalPage.selectVendorList();
        proposalPage.uploadTestFile();
        proposalPage.enterLocationType("Home Office/Residential Building");
    }

    @Then("^Provide the Purchase details on Purchase page$")
    public void provide_the_Purchase_details_on_Purchase_page() throws InterruptedException   {
        CostPage costPage=new CostPage(driver);
        costPage.selectPurchaseType();
    }

    @Then("^Provide tasks, reason and percentage Efficiency on the Business Impacts Page$")
    public void provide_tasks_reason_and_percentage_Efficiency_on_the_Business_Impacts_Page() throws InterruptedException   {
        BusinessImpactPage businessImpactPage=new BusinessImpactPage(driver);
        businessImpactPage.provideBusinessImpact();
    }

    @Then("^Provide answers for the questionnaire and acknowledge on Declare and Review Page$")
    public void provide_answers_for_the_questionnaire_and_acknowledge_on_Declare_and_Review_Page() throws InterruptedException   {
        DeclareReviewPage declareReviewPage=new DeclareReviewPage(driver);
        declareReviewPage.provideAnswers();
    }

    @Then("^Provide the aggrement and submit the application on the company Profile Page" +
            " and Validate all the fields matches the input provided at each page$")
    public void provide_the_aggrement_and_submit_the_application_on_the_company_Profile_Page() throws InterruptedException   {
        CompanyProfilePage companyProfilePage=new CompanyProfilePage(driver);
        companyProfilePage.agreement();
    }


    @Then("^Validate that application is submitted successfuly$")
    public void validate_that_application_is_submitted_successfuly() throws InterruptedException   {
        SummaryPage summaryPage=new SummaryPage(driver);
        summaryPage.checkSuccessMessage();
    }
}
