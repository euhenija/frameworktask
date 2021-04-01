package webdrivertasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdrivertasks.waitings.WebElementWaitingManager;

import static webdrivertasks.waitings.WebElementWaitingManager.*;

public class CalculatorPage {
    private WebDriver driver;
    private static final String EXTERNAL_IFRAME_XPATH = "//devsite-iframe/iframe";
    private static final String FINAL_COST_XPATH = "//b[contains(text(),'Total Estimated Cost')]";
    private static final String EXPANDED_DROPDOWN_TEMPLATE_XPATH = "//div[contains(@class,'clickable')]//div[contains(text(),'%s')]";
    private static final String GOOGLE_CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//md-input-container/input[contains(@ng-model,'quantity')]")
    private WebElement numberOfInstancesInputArea;

    @FindBy(xpath = "//md-select[contains(@ng-model,'os')]")
    private WebElement operatingSystemDropDown;

    @FindBy(xpath = "//*[@placeholder='VM Class']")
    private WebElement machineClassDropDown;

    @FindBy(xpath = "//md-list[contains(@ng-repeat,'filterComputeItems')]//div[contains(text(),'VM class')]")
    private WebElement currentMachineClass;

    @FindBy(xpath = "//*[@placeholder='Instance type']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//md-list[contains(@ng-repeat,'filterComputeItems')]//div[contains(text(),'Instance type')]")
    private WebElement currentInstanceType;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.location')]")
    private WebElement dataCenterLocationDropDown;

    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.cud')]")
    private WebElement machineCommitedUsageDropDown;

    @FindBy(xpath = "//button[contains(@ng-click,'ComputeEngineForm')]")
    private WebElement machineAddEstimationButton;

    @FindBy(xpath = "//button[contains(@ng-click,'addSoleTenant')]")
    private WebElement nodeAddEstimationButton;

    @FindBy(xpath = "//input[@name='nodesCount']")
    private WebElement numberOfNodesInputArea;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model,'addGPUs')]")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropDown;

    @FindBy(xpath = "//md-select[contains(@ng-model,'soleTenant.cud')]")
    private WebElement nodeCommitedUsageDropdown;

    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    private WebElement googleMessageButton;

    @FindBy(xpath = "//button[contains(@ng-click,'showEmailForm')]")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInputArea;

    @FindBy(xpath = "//button[contains(@ng-click,'emailQuote(true)')]")
    private WebElement sendEmailButton;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage openCalculatorPage() {
        this.driver.get(GOOGLE_CALCULATOR_PAGE_URL);
        return this;
    }

    public CalculatorPage clickMessageButton() {
        waitForVisibilityOfWebElement(googleMessageButton);
        googleMessageButton.click();
        return this;
    }

    public CalculatorPage inputNumberOfInstances(String numberOfInstances) {
        switchToInternalFrame();
        waitForVisibilityOfWebElement(numberOfInstancesInputArea);
        numberOfInstancesInputArea.click();
        numberOfInstancesInputArea.sendKeys(numberOfInstances);
        return this;
    }

    public CalculatorPage switchToInternalFrame() {
        waitForPresenceOfElementLocatedByXpath(EXTERNAL_IFRAME_XPATH);
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        return this;
    }

    public CalculatorPage selectOperatingSystem(String operationSystem) {
        waitForVisibilityOfWebElement(operatingSystemDropDown);
        operatingSystemDropDown.click();
        waitForPresenceOfElementLocatedByXpath(String.format(EXPANDED_DROPDOWN_TEMPLATE_XPATH, operationSystem)).click();
        return this;
    }

    public CalculatorPage selectMachineClass(String machineClass) {
        waitForVisibilityOfWebElement(machineClassDropDown);
        machineClassDropDown.click();
        waitForPresenceOfElementLocatedByXpath(String.format(EXPANDED_DROPDOWN_TEMPLATE_XPATH, machineClass)).click();
        return this;
    }

    public CalculatorPage selectMachineType(String machineType) {
        waitForVisibilityOfWebElement(machineTypeDropDown);
        machineTypeDropDown.click();
        waitForPresenceOfElementLocatedByXpath(String.format(EXPANDED_DROPDOWN_TEMPLATE_XPATH, machineType)).click();
        return this;
    }

    public CalculatorPage selectDatacenterLocation(String dataCenterLocation) {
        waitForVisibilityOfWebElement(dataCenterLocationDropDown);
        dataCenterLocationDropDown.click();
        waitForPresenceOfElementLocatedByXpath(String.format(EXPANDED_DROPDOWN_TEMPLATE_XPATH, dataCenterLocation)).click();
        return this;
    }

    public CalculatorPage selectMachineCommitedUsage(String committedUsage) {
        waitForVisibilityOfWebElement(machineCommitedUsageDropDown);
        machineCommitedUsageDropDown.click();
        waitForPresenceOfElementLocatedByXpath(String.format(EXPANDED_DROPDOWN_TEMPLATE_XPATH, committedUsage)).click();
        return this;
    }

    public CalculatorPage inputNumberOfNodes(String numberOfNodes) {
        waitForVisibilityOfWebElement(numberOfNodesInputArea);
        numberOfNodesInputArea.click();
        numberOfNodesInputArea.sendKeys(numberOfNodes);
        addGPUCheckbox.click();
        return this;
    }

    public CalculatorPage selectNumberOfGPUs(String numberOfGPUs) {
        waitForVisibilityOfWebElement(numberOfGPUDropDown);
        numberOfGPUDropDown.click();
        waitForPresenceOfElementLocatedByXpath(String.format(EXPANDED_DROPDOWN_TEMPLATE_XPATH, numberOfGPUs)).click();
        return this;
    }

    public CalculatorPage selectLocalSSD(String localSSD) {
        waitForVisibilityOfWebElement(localSSDDropDown);
        localSSDDropDown.click();
        waitForPresenceOfElementLocatedByXpath(String.format(EXPANDED_DROPDOWN_TEMPLATE_XPATH, localSSD)).click();
        return this;
    }

    public CalculatorPage selectNodeCommitedUsage(String committedUsage) {
        waitForVisibilityOfWebElement(nodeCommitedUsageDropdown);
        nodeCommitedUsageDropdown.click();
        waitForPresenceOfElementLocatedByXpath(String.format(EXPANDED_DROPDOWN_TEMPLATE_XPATH, committedUsage)).click();
        return this;
    }

    public CalculatorPage computeEngineCost() {
        waitForVisibilityOfWebElement(machineAddEstimationButton);
        machineAddEstimationButton.click();
        return this;
    }

    public CalculatorPage computeNodesCost() {
        waitForVisibilityOfWebElement(nodeAddEstimationButton);
        nodeAddEstimationButton.click();
        return this;
    }

    public CalculatorPage clickToEstimateEmail() {
        switchToInternalFrame();
        waitForVisibilityOfWebElement(emailEstimateButton);
        emailEstimateButton.click();
        return this;
    }

    public CalculatorPage pasteEmail(String email){
        waitForVisibilityOfWebElement(emailInputArea);
        emailInputArea.click();
        emailInputArea.sendKeys(email);
        return this;
    }

    public CalculatorPage clickButtonToSendEmail(){
        waitForVisibilityOfWebElement(sendEmailButton);
        sendEmailButton.click();
        return this;
    }

    public boolean checkTotalEstimatedCost(String estimatedCost) {
        return waitForPresenceOfElementLocatedByXpath(FINAL_COST_XPATH).getText().contains(estimatedCost);
    }

    public boolean checkMachineClass(String machineClass) {
        return waitForVisibilityOfWebElement(currentMachineClass).getText().toLowerCase().contains(machineClass.toLowerCase());
    }

    public boolean checkInstanceType(String instanceType) {
        return waitForVisibilityOfWebElement(currentInstanceType).getText().toLowerCase().contains(instanceType.toLowerCase());
    }

}
