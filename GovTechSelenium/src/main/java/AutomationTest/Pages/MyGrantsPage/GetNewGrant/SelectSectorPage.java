package AutomationTest.Pages.MyGrantsPage.GetNewGrant;

import AutomationTest.Pages.MyGrantsPage.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectSectorPage {
    private WebDriver driver;

    @FindBy(xpath="//div[contains(text(),\"Building & Construction\")]")
    private WebElement BuildingConstruction;

    @FindBy(id="Builders (Contractors)")
    private WebElement subType;

    public SelectSectorPage(WebDriver driver)throws InterruptedException{
        this.driver=driver;
        navigateToSelectSectorPage();
        PageFactory.initElements(driver,this);
    }
    public void selectSector() {
        BuildingConstruction.click();
        subType.click();
    }


    public void navigateToSelectSectorPage() throws InterruptedException{
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.clickOnGetNewGrant();
    }
}
