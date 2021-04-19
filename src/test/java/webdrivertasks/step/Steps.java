package webdrivertasks.step;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import webdrivertasks.model.Machine;
import webdrivertasks.page.CalculatorPage;
import webdrivertasks.page.GoogleCloudHomePage;
import webdrivertasks.page.TenMinuteMailPage;

import java.util.ArrayList;

import static webdrivertasks.waitings.WebElementWaitingManager.waitForPresenceOfElementLocatedByXpath;

public class Steps {
    private WebDriver driver;
    private CalculatorPage calculatorPage;
    private TenMinuteMailPage tenMinuteMailPage;
//    private final String OPERATION_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
//    private final String MACHINE_CLASS = "Regular";
//    private final String MACHINE_TYPE = "e2-standard-8";
//    private final String DATACENTER_LOCATION = "Frankfurt";
//    private final String COMMITTED_USAGE = "1 Year";
//    private final String LOCAL_SSD = "24x375 GB";
//    public static final String NUMBER_OF_INSTANCES = "4";
//    public static final String NUMBER_OF_NODES = "1";
//    public static final String NUMBER_OF_GPUS = "4";
    private final String TEN_MINUTE_MAIL_PAGE_OPENING_SCRIPT = "window.open('https://10minutemail.com/','_blank');";
    private ArrayList<String> tabs;
    private String email;
    private static final String FINAL_COST_XPATH = "//b[contains(text(),'Total Estimated Cost')]";
    private Machine machine;


    public Steps(WebDriver driver) {
        this.driver = driver;
        machine = new Machine.MachineBuilder()
                .withNumberOfInstances("4")
                .withOperationSystem("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .withClass("Regular")
                .withType("e2-standard-8")
                .withDataCenterLocation("Frankfurt")
                .withCommitedUsage("1 Year")
                .withNumberOfNodes("1")
                .withNumberOfGPU("4")
                .withLocalSSD("24x375 GB").build();
    }

    public Steps goToCalculatorPage() {
        new GoogleCloudHomePage(driver)
                .openPage()
                .pasteAndSearch("Google Cloud Platform Pricing Calculator")
                .searchAskedCalculator()
                .goToCalculatorPage();
        return this;
    }

    public Steps selectEngineProperties() {
        calculatorPage = new CalculatorPage(driver)
                //.clickMessageButton()
                .inputNumberOfInstances(machine.getNumberOfInstances())
                .selectOperatingSystem(machine.getOperationSystem())
                .selectMachineClass(machine.getMachineClass())
                .selectMachineType(machine.getMachineType())
                .selectDatacenterLocation(machine.getDataCenterLocation())
                .selectMachineCommitedUsage(machine.getCommitedUsage());
        return this;
    }

    public Steps startFromCalculatorPage() {
        calculatorPage = new CalculatorPage(driver)
                .openCalculatorPage()
                //.clickMessageButton()
                .inputNumberOfInstances(machine.getNumberOfInstances())
                .selectOperatingSystem(machine.getOperationSystem())
                .selectMachineClass(machine.getMachineClass())
                .selectMachineType(machine.getMachineType())
                .selectDatacenterLocation(machine.getDataCenterLocation())
                .selectMachineCommitedUsage(machine.getCommitedUsage());
        return this;
    }

    public Steps selectNodeProperties() {
        calculatorPage
                .inputNumberOfNodes(machine.getNumberOfNodes())
                .selectNumberOfGPUs(machine.getNumberOfGPU())
                .selectLocalSSD(machine.getLocalSSD())
                .selectNodeCommitedUsage(machine.getCommitedUsage());
        return this;
    }

    public CalculatorPage estimateTotalCost() {
        calculatorPage
                .computeEngineCost()
                .computeNodesCost();
        return calculatorPage;
    }

    public Steps estimateTotalCostToCompareOneFromEmail() {
        calculatorPage
                .computeEngineCost()
                .computeNodesCost();
        return this;
    }

    public Steps sendEmail() {
        tenMinuteMailPage = new TenMinuteMailPage(driver);
        email = tenMinuteMailPage.copyEmail();
        driver.switchTo().window(tabs.get(0));
        calculatorPage
                .clickToEstimateEmail()
                .pasteEmail(email)
                .clickButtonToSendEmail();
        return this;
    }

    public Steps openNewTenMinuteMailPageAndSwitchIt() {
        ((JavascriptExecutor) driver).executeScript(TEN_MINUTE_MAIL_PAGE_OPENING_SCRIPT);
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public String getTotalCostFromEmail() {
        driver.switchTo().window(tabs.get(1));
        String emailResult = tenMinuteMailPage.openGoogleEmail().getEstimationCostInformationFromEmail();
        driver.switchTo().window(tabs.get(0));
        return emailResult;
    }

    public boolean checkCostFromEmailAndCalculatorPageAreEqual(String costFromEmail){
        calculatorPage.switchToInternalFrame();
        return waitForPresenceOfElementLocatedByXpath(FINAL_COST_XPATH).getText().contains(costFromEmail);
    }

}
