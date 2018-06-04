package AutomationTest.Pages.MyGrantsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DeclareReviewPage {

    private WebDriver driver;

    public DeclareReviewPage(WebDriver driver)throws InterruptedException {
        this.driver = driver;
        navigateToDelareReviewPage();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='controls bgp-radio-text-format']//span[@class='radiobutton']")
    private List<WebElement> radioButtonlist;

    @FindBy(xpath="//input[@id='react-declaration-consent_acknowledgement_check']")
    private WebElement declare;

    @FindBy(xpath="//input[@id='react-declaration-criminal_liability_check-false']/following-sibling::span[@class='radiobutton']")
    private WebElement radioButton_No_Question1;

    @FindBy(id="review-btn")
    private WebElement reviewButton;

    public void provideAnswers()throws InterruptedException{
        List<WebElement> radioButtonList=driver.findElements(By.xpath("//div[@class='controls bgp-radio-text-format']/label[@class='bgp-radio'][1]/span[@class='radiobutton']"));
        radioButtonList.get(0).click();
        radioButtonList.get(1).click();
        radioButtonList.get(2).click();
        radioButtonList.get(3).click();
        radioButtonList.get(4).click();
        radioButtonList.get(5).click();
        radioButtonList.get(6).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        declare.click();
        reviewButton.click();
    }

    public void navigateToDelareReviewPage() throws InterruptedException{
        BusinessImpactPage businessImpactPage=new BusinessImpactPage(driver);
        businessImpactPage.provideBusinessImpact();
    }
}
