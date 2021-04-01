package webdrivertasks.waitings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdrivertasks.driver.WebDriverSetUp;

public class WebElementWaitingManager {

    private static final int DEFAULT_WAIT_TIMEOUT_SECONDS = 30;

    private WebElementWaitingManager() {
    }

    public static WebElement waitForVisibilityOfWebElement(WebElement webElement) {
        return new WebDriverWait(WebDriverSetUp.getDriver(), DEFAULT_WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static WebElement waitForElementIsClickable(WebElement webElement) {
        return new WebDriverWait(WebDriverSetUp.getDriver(), DEFAULT_WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static WebElement waitForPresenceOfElementLocatedByXpath(String xpathLocator) {
        return new WebDriverWait(WebDriverSetUp.getDriver(), DEFAULT_WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
    }

    public static WebElement waitForVisibilityOfElementLocatedByXpath(String xpathLocator) {
        return new WebDriverWait(WebDriverSetUp.getDriver(), DEFAULT_WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }

    public static void waitForVisibilityOfAllWebElementsOnThePage(WebElement... webElements) {
        new WebDriverWait(WebDriverSetUp.getDriver(), DEFAULT_WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElements(webElements));
    }
}
