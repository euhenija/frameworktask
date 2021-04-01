package webdrivertasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static webdrivertasks.waitings.WebElementWaitingManager.*;

public class TenMinuteMailPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='message_top']")
    WebElement emailMessageArea;

    @FindBy(xpath = "//div[@id='copy_address']")
    WebElement copyIcon;

    @FindBy(xpath = "//tr[@id='mobilepadding']//td[2]/h3")
    WebElement estimatedCostInformation;

    @FindBy(xpath = "//button[text()='AGREE']")
    WebElement agreeButton;

    public TenMinuteMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String copyEmail(){
        waitForVisibilityOfWebElement(copyIcon).click();

        String myText = null;
        try {
            myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return myText;
    }

    public TenMinuteMailPage openGoogleEmail(){
        waitForVisibilityOfWebElement(emailMessageArea).click();
        return this;
    }

    public TenMinuteMailPage agreeWithConditions(){
        waitForVisibilityOfWebElement(agreeButton).click();
        return this;
    }

    public String getEstimationCostInformationFromEmail(){
        return waitForVisibilityOfWebElement(estimatedCostInformation).getText();
    }

}
