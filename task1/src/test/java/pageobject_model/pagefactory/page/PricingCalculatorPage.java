package pageobject_model.pagefactory.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id='c11']")
    WebElement numberOfInstancesInput;
    @FindBy(xpath = "//span[contains(text(), 'Operating System / Software')]/ancestor::div[2]")
    WebElement operationSystemSoftwareInput;
    WebElement provisioningModelInput;
    @FindBy(xpath = "//span[contains(text(), 'Machine Family')]/ancestor::div[2]")
    WebElement machineFamilyInput;
    @FindBy(xpath = "//span[contains(text(), 'Series')]/ancestor::div[2]")
    WebElement seriesInput;
    @FindBy(xpath = "//span[contains(text(), 'Machine type')]/ancestor::div[2]")
    WebElement machineTypeInput;
    @FindBy(xpath = "//button[contains(@aria-label, 'Add GPUs')]/ancestor::div[4]")
    WebElement addGPUsInput;
    @FindBy(xpath = "//span[contains(text(), 'GPU Model')]/ancestor::div[2]")
    WebElement GPUTypeInput;
    @FindBy(xpath = "//span[contains(text(), 'Number of GPUs')]/ancestor::div[2]")
    WebElement numberOfGPUsInput;
    @FindBy(xpath = "//span[contains(text(), 'Local SSD')]/ancestor::div[2]")
    WebElement localSSDInput;
    @FindBy(xpath = "//span[contains(text(), 'Region')]/ancestor::div[2]")
    WebElement datacenterLocationInput;

    WebElement committedUsageInput;

    @FindBy(xpath = "//span[contains(text(), 'Add to estimate')]/ancestor::button")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//h2[contains(text(), 'Cost details')]/ancestor::div[2]")
    WebElement resultBlock;
    @FindBy(xpath = "//button[contains(@aria-label, 'Open Share Estimate dialog')]")
    WebElement openShareEstimate;
    @FindBy(xpath = "//a[contains(@track-name, 'open estimate summary')]")
    WebElement openEstimateSummary;
    @FindBy(xpath = "//div[contains(@aria-label, 'Share Estimate Dialog')]")
    WebElement shareEstimateDialog;
    @FindBy(xpath = "//div[contains(text(), 'Estimated cost')]/following-sibling::div/label")
    WebElement estimatedCostLabel;

    public PricingCalculatorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void fillComputeEngineForm(int numberOfInstances, String operationSystemSoftware, String provisioningModel, String machineFamily,
                                      String series, String machineType, boolean addGPUs, String GPUType, int numberOfGPUs, String localSSD,
                                      String datacenterLocation, String committedUsage) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(numberOfInstancesInput));
        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys(String.valueOf(numberOfInstances));

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(operationSystemSoftwareInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '"+ operationSystemSoftware +"')]/ancestor::li")))
                .click();

        provisioningModelInput =new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), '"+provisioningModel+"')]/parent::*")));
        provisioningModelInput.click();

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(machineFamilyInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+machineFamily+"')]/ancestor::li")))
                .click();

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(seriesInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+series+"')]/ancestor::li")))
                .click();

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(machineTypeInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+machineType+"')]/ancestor::li")))
                .click();

        if(addGPUs) {
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(addGPUsInput));
            addGPUsInput.click();

            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(GPUTypeInput))
                    .click();
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+GPUType+"')]/ancestor::li")))
                    .click();

            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(numberOfGPUsInput))
                    .click();
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@aria-label, 'Number of GPUs')]//li[contains(@data-value, '"+numberOfInstances+"')]")))
                    .click();
        }
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(localSSDInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+localSSD+"')]/ancestor::li")))
                .click();

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(datacenterLocationInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+datacenterLocation+"')]/ancestor::li")))
                .click();


        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(), '"+committedUsage+"')]/ancestor::div[1]")));
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), '"+committedUsage+"')]/ancestor::div[1]")))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBe(By.xpath("//div[contains(text(), 'Estimated cost')]/following-sibling::div/label"), "$19,096.38"));
    }

    public void addToEstimate() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addToEstimateButton))
                .click();
    }

    public boolean openEstimateShare() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-300);", openShareEstimate);
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@aria-label, 'Open Share Estimate dialog')]")));
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until((ExpectedConditions.elementToBeClickable(openShareEstimate)))
                    .click();
            return true;
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public EstimateSummaryPage openEstimateSummary() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@track-name, 'open estimate summary')]")));
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(openEstimateSummary)))
                .click();
        return new EstimateSummaryPage(webDriver);
    }
}

