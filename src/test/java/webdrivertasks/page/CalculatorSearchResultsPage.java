package webdrivertasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdrivertasks.waitings.WebElementWaitingManager;

public class CalculatorSearchResultsPage {

    private WebDriver driver;

    @FindBy(xpath = "//a/b[text()=\"Google Cloud Platform Pricing Calculator\"]")
    private WebElement calculatorPageLink;

    public CalculatorSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage goToCalculatorPage(){
        WebElementWaitingManager.waitForVisibilityOfWebElement(calculatorPageLink);
        calculatorPageLink.click();
       return new CalculatorPage(driver);
    }

}
