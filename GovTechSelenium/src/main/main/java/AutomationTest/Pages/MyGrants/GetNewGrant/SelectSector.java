package AutomationTest.Pages.MyGrants.GetNewGrant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectSector {
    private WebDriver driver;

    @FindBy(xpath="//div[contains(text(),\"Building & Construction\")]")
    private WebElement BuildingConstruction;
    @FindBy(id="Builders (Contractors)")
    private WebElement subType;

        public SelectSector(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        }
        public void selectSector() {
        BuildingConstruction.click();
        subType.click();
        }
}
