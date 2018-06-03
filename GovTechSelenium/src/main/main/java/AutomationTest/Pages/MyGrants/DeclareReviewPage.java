package AutomationTest.Pages.MyGrants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DeclareReviewPage {

    private WebDriver driver;

    public DeclareReviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='controls bgp-radio-text-format']//span[@class='radiobutton']")
    private List<WebElement> radioButtonList;

    //Click on Review

    //takes time to load the next page

    //after another page is loaded
    @FindBy(xpath="//input[@id='react-declaration-consent_acknowledgement_check']")
    private WebElement declare;

    @FindBy(id="review-btn")
    private WebElement reviewButton;

    public void provideAnswers(){
        declare.click();
        radioButtonList.get(0).click();
        radioButtonList.get(2).click();
        radioButtonList.get(4).click();
        radioButtonList.get(6).click();
        radioButtonList.get(8).click();
        radioButtonList.get(10).click();
        radioButtonList.get(12).click();
        radioButtonList.get(14).click();
        reviewButton.click();
    }
}
