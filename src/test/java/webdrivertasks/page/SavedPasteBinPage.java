package webdrivertasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webdrivertasks.waitings.WebElementWaitingManager.waitForPresenceOfElementLocatedByXpath;

public class SavedPasteBinPage {
    private WebDriver driver;
    private static final String SAVED_PASTEBIN_PAGE_TEXT_AREA_LOCATOR = "//textarea";
    private static final String SAVED_PASTEBIN_PAGE_TITLE_LOCATOR = "//title[starts-with(text(),'how to gain dominance among developer')]";

    public SavedPasteBinPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkHeaderToTitleAccordance(String title) {
        waitForPresenceOfElementLocatedByXpath(SAVED_PASTEBIN_PAGE_TITLE_LOCATOR);
        return driver.getTitle().contains(title);
    }

    public boolean checkBashPropertyIsActive(String bashPath) {
        return waitForPresenceOfElementLocatedByXpath(bashPath).isDisplayed();
    }

    public boolean checkPastedToDisplayedTextAccordance(String askedCode) {
        boolean codeCheckResult = true;
        String pastedCode = waitForPresenceOfElementLocatedByXpath(SAVED_PASTEBIN_PAGE_TEXT_AREA_LOCATOR).getText();
        if (!pastedCode.equals(askedCode)) {
            codeCheckResult = false;
        }
        return codeCheckResult;
    }
}
