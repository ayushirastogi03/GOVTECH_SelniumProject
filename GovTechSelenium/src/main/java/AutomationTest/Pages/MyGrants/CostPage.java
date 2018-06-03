package AutomationTest.Pages.MyGrants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


//It takes a long time pause to load the cost page after the proposal page

public class CostPage {

    private WebDriver driver;

    @FindBy(xpath="//span[contains(text(),\"CostPage\")]")
    private WebElement cost;

    @FindBy(xpath="//span[@id='react-select-project_cost-psg_payment_mode_id--value']/div[@class='Select-placeholder']")
    private WebElement purchaseHow;

    @FindBy(xpath="//input[@id='react-project_cost-cost_in_billing_currency']")
    private WebElement purchasePrice;

    @FindBy(xpath="//div[@class='currency-input-group input-group']//input[@id='react-project_cost-ot_cost_in_billing_currency']")
    private WebElement anyOtherFees;

    @FindBy(xpath="//div[@id='react-project_cost-estimated_cost']")
    private WebElement estimatedTotal;


    @FindBy(id = "next-btn")
    private WebElement NextButton;

    //validate total - purchase price + Any other fees

    public CostPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void selectPurchaseType()throws InterruptedException{
        purchaseHow.click();
       // Thread.sleep(1000);
       // Select select=new Select(purchaseHow);
        List<WebElement> purchasehow=driver.findElements(By.xpath("//span[@id='react-select-project_cost-psg_payment_mode_id--value']/div[@class='Select-placeholder']"));
       if(purchasehow.get(0).isDisplayed()){
           purchasehow.get(0).click();
       }
        //select.selectByVisibleText("Direct Purchase");
        Thread.sleep(1000);

        purchasePrice.sendKeys("1000");
        anyOtherFees.sendKeys("1000");
        estimatedTotal.getAttribute("value");
       //if(Integer.valueOf(estimatedTotal.getAttribute("value"))
               // ==(Integer.valueOf(purchasePrice.getText()+anyOtherFees.getText()))){
           NextButton.click();
       }
}


