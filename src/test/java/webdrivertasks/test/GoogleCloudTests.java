package webdrivertasks.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertasks.driver.WebDriverSetUp;
import webdrivertasks.page.CalculatorPage;
import webdrivertasks.step.Steps;

public class GoogleCloudTests {

    private WebDriver driver;
    private Steps step;
    private final String MACHINE_CLASS = "Regular";
    private final String MACHINE_TYPE = "e2-standard-8";
    private final String MANUALLY_CHECKED_TOTAL_COST = "6,940.38";


    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = WebDriverSetUp.getDriver();
        this.driver.manage().window().maximize();
        step = new Steps(driver);
    }

    @Test
    public void checkHurtMePlentyTask() {
        CalculatorPage calculatorPage = step.goToCalculatorPage()
                .selectEngineProperties()
                .selectNodeProperties()
                .estimateTotalCost();

        Assert.assertTrue(calculatorPage.checkTotalEstimatedCost(MANUALLY_CHECKED_TOTAL_COST));
        Assert.assertTrue(calculatorPage.checkMachineClass(MACHINE_CLASS));
        Assert.assertTrue(calculatorPage.checkInstanceType(MACHINE_TYPE));
    }

    @Test
    public void checkHardcoreTask() {
        String totalCostFromEmail = step.startFromCalculatorPage()
                .selectNodeProperties()
                .estimateTotalCostToCompareOneFromEmail()
                .openNewTenMinuteMailPageAndSwitchIt()
                .sendEmail()
                .getTotalCostFromEmail();

       Assert.assertTrue(step.checkCostFromEmailAndCalculatorPageAreEqual(totalCostFromEmail));
    }

    @AfterClass(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
