package pageobject_model.pagefactory.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPageLegacy {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id='tab-item-1']")
    WebElement computeEngineButton;
    @FindBy(xpath = "//*[@id='input_100']")
    WebElement numberOfInstancesInput;
    @FindBy(xpath = "//*[@id='select_113']")
    WebElement operationSystemSoftwareInput;
    @FindBy(xpath = "//*[@id='select_117']")
    WebElement provisioningModelInput;
    @FindBy(xpath = "//*[@id='select_123']")
    WebElement machineFamilyInput;
    @FindBy(xpath = "//*[@id='select_125']")
    WebElement seriesInput;
    @FindBy(xpath = "//*[@id='select_127']")
    WebElement machineTypeInput;
    @FindBy(xpath = "//md-checkbox[contains(@aria-label, 'Add GPUs')]")
    WebElement addGPUsInput;
    @FindBy(xpath = "//*[@id='select_510']")
    WebElement GPUTypeInput;
    @FindBy(xpath = "//*[@id='select_512']")
    WebElement numberOfGPUsInput;
    @FindBy(xpath = "//*[@id='select_469']")
    WebElement localSSDInput;
    @FindBy(xpath = "//*[@id='select_133']")
    WebElement datacenterLocationInput;
    @FindBy(xpath = "//*[@id='select_140']")
    WebElement committedUsageInput;

    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')]")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@id='resultBlock']")
    WebElement resultBlock;

    public PricingCalculatorPageLegacy(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public PricingCalculatorPageLegacy openPage() {
        webDriver.get("https://cloud.google.com/products/calculator-legacy");
        return this;
    }
    public PricingCalculatorPageLegacy clickComputeEngine() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.switchTo().frame(0);
        webDriver.switchTo().frame("myFrame");

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(computeEngineButton))
                .click();
        return this;
    }

    public void fillComputeEngineForm(int numberOfInstances, String operationSystemSoftware, String provisioningModel, String machineFamily,
                                      String series, String machineType, boolean addGPUs, String GPUType, int numberOfGPUs, String localSSD,
                                      String datacenterLocation, String committedUsage) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(numberOfInstancesInput));
        numberOfInstancesInput.sendKeys(String.valueOf(numberOfInstances));

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(operationSystemSoftwareInput));
        operationSystemSoftwareInput.sendKeys(operationSystemSoftware);
        operationSystemSoftwareInput.sendKeys(Keys.ENTER);

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(provisioningModelInput));
        provisioningModelInput.sendKeys(provisioningModel);
        provisioningModelInput.sendKeys(Keys.ENTER);

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(machineFamilyInput));
        machineFamilyInput.sendKeys(machineFamily);
        machineFamilyInput.sendKeys(Keys.ENTER);

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(seriesInput));
        seriesInput.sendKeys(series);
        seriesInput.sendKeys(Keys.ENTER);

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(machineTypeInput));
        machineTypeInput.sendKeys(machineType);
        machineTypeInput.sendKeys(Keys.ENTER);

        if(addGPUs) {
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(addGPUsInput));
            addGPUsInput.click();

            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(GPUTypeInput));
            GPUTypeInput.sendKeys(GPUType);
            GPUTypeInput.sendKeys(Keys.ENTER);

            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(numberOfGPUsInput));
            numberOfGPUsInput.sendKeys(String.valueOf(numberOfGPUs));
        }

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(localSSDInput));
        localSSDInput.sendKeys(localSSD);
        localSSDInput.sendKeys(Keys.ENTER);

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(datacenterLocationInput));
        datacenterLocationInput.sendKeys(datacenterLocation);
        datacenterLocationInput.sendKeys(Keys.ENTER);

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(committedUsageInput));
        committedUsageInput.sendKeys(committedUsage);
        committedUsageInput.sendKeys(Keys.ENTER);

        addToEstimate();
    }

    public void addToEstimate() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addToEstimateButton))
                .click();
    }

    public boolean openEstimateSummary() {
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(resultBlock));
            return true;
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String getCostEstimateSummary() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-content/md-card//h2/b")))
                .getText().strip();
    }
    public String getNumberOfInstances(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-content/md-list/div/div[1]//span")))
                .getText().strip();
    }
    public String getOperationSystemSoftware(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-content/md-list/md-list-item[6]//span")))
                .getText().strip();
    }
    public String getProvisioningModel(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-content/md-list/md-list-item[4]/div[1]")))
                .getText().strip();
    }
    public String getMachineType(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-content/md-list/md-list-item[5]/div[1]")))
                .getText().strip();
    }
    public String getLocalSSD(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-content/md-list/md-list-item[7]/div[1]")))
                .getText().strip();
    }
    public String getDatacenterLocation(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-content/md-list/md-list-item[1]/div[1]")))
                .getText().strip();
    }
    public String getCommittedUsage(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-content/md-list/md-list-item[3]/div[1]")))
                .getText().strip();
    }
}

