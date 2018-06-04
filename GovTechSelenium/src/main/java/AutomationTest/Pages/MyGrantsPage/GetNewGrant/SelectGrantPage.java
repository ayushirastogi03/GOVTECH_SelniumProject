package AutomationTest.Pages.MyGrantsPage.GetNewGrant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectGrantPage {
    private WebDriver driver;

    @FindBy(xpath="//div[contains(text(),\"Upgrade\")]")
    private WebElement selectGrant;

    public SelectGrantPage(WebDriver driver)throws InterruptedException{
        this.driver=driver;
        navigateToSelectGrantPage();
        PageFactory.initElements(driver,this);
    }

    public void selectGrant() {
        selectGrant.click();
    }

    public void navigateToSelectGrantPage()throws InterruptedException{
        SelectSectorPage selectSectorPage =new SelectSectorPage(driver);
        selectSectorPage.selectSector();
    }
}
