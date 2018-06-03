package AutomationTest.Pages.MyGrants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class BusinessImpactPage {

    private WebDriver driver;

    public BusinessImpactPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//textarea[@id='react-project_impact-impact_description']")
    private WebElement describe;
    @FindBy(xpath="//input[@id='react-project_impact-task_description']")
    private WebElement tasks;
    @FindBy(xpath="//input[@id='react-project_impact-task_efficiency_percentage']")
    private WebElement percentageEfficiencyNeeded;
    @FindBy(id = "next-btn")
    private WebElement NextButton;


    public void provideBusinessImpact() {
        describe.sendKeys("test");
        tasks.sendKeys("test");
        percentageEfficiencyNeeded.sendKeys("40");
        if (Integer.valueOf(percentageEfficiencyNeeded.getAttribute("value")) < 100) {
            NextButton.click();
        }

        //check if the percentage is not equal to or more than 100
    }
}


