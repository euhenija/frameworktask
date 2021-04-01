package webdrivertasks.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static webdrivertasks.waitings.WebElementWaitingManager.waitForVisibilityOfAllWebElementsOnThePage;

public class PastebinHomePage {
    private static final String PASTEBIN_HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement inputTextArea;

    @FindBy(id = "postform-name")
    private WebElement inputTitleArea;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement pasteNewPasteButton;

    @FindBy(css = "#select2-postform-expiration-container")
    private WebElement expirationDropdown;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement selectTenMinutesExpiration;

    @FindBy(css = "#select2-postform-format-container")
    private WebElement textSyntaxHighlightDropdown;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement selectBashFormat;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        this.driver.get(PASTEBIN_HOMEPAGE_URL);
        this.driver.manage().window().maximize();
        waitForVisibilityOfAllWebElementsOnThePage(inputTextArea, inputTitleArea, pasteNewPasteButton, expirationDropdown);
        return this;
    }

    public PastebinHomePage inputTextInTextArea(String text) {
        inputTextArea.sendKeys(text);
        return this;
    }

    public PastebinHomePage inputTextInTitleArea(String title) {
        inputTitleArea.sendKeys(title);
        return this;
    }

    public PastebinHomePage selectExpirationTime() {
        expirationDropdown.click();
        selectTenMinutesExpiration.click();
        return this;
    }

    public PastebinHomePage selectSyntaxHighlighting() {
        textSyntaxHighlightDropdown.click();
        selectBashFormat.click();
        return this;
    }

    public SavedPasteBinPage submitNewPaste() {
        pasteNewPasteButton.click();
        return new SavedPasteBinPage(driver);
    }

}
