package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator";
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

    @FindBy(xpath = "//button[contains(@aria-label, 'Open Share Estimate dialog')]")
    WebElement openShareEstimate;
    @FindBy(xpath = "//a[contains(@track-name, 'open estimate summary')]")
    WebElement openEstimateSummary;

    public PricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }
    public static String getHOMEPAGE_URL() {
        return HOMEPAGE_URL;
    }

    public PricingCalculatorPage fillComputeEngineForm(int numberOfInstances, String operationSystemSoftware,
                                                       String provisioningModel, String machineFamily, String series,
                                                       String machineType, String localSSD, String datacenterLocation,
                                                       String committedUsage) {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(numberOfInstancesInput));
        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys(String.valueOf(numberOfInstances));
        logger.info("Number of instances '" + numberOfInstances + "' selected");

        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(operationSystemSoftwareInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '"+ operationSystemSoftware +"')]/ancestor::li")))
                .click();
        logger.info("Operation system software '" + operationSystemSoftware + "' selected");

        provisioningModelInput =new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), '"+provisioningModel+"')]/parent::*")));
        provisioningModelInput.click();
        logger.info("Provision model '" + provisioningModel + "' selected");

        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(machineFamilyInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+machineFamily+"')]/ancestor::li")))
                .click();
        logger.info("Machine family '" + machineFamily + "' selected");

        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(seriesInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+series+"')]/ancestor::li")))
                .click();
        logger.info("Series '" + series + "' selected");

        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(machineTypeInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+machineType+"')]/ancestor::li")))
                .click();
        logger.info("machine type '" + machineType + "' selected");

        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(localSSDInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+localSSD+"')]/ancestor::li")))
                .click();
        logger.info("Local SSD '" + localSSD + "' selected");

        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(datacenterLocationInput))
                .click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+datacenterLocation+"')]/ancestor::li")))
                .click();
        logger.info("Datacenter Location '" + datacenterLocation + "' selected");

        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(), '"+committedUsage+"')]/ancestor::div[1]")));
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), '"+committedUsage+"')]/ancestor::div[1]")))
                .click();
        logger.info("Committed usage '" + committedUsage + "' selected");
        return this;
    }
    public PricingCalculatorPage addGPUs(boolean addGPUs, String GPUType, int numberOfGPUs){
            new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.visibilityOf(addGPUsInput));
            addGPUsInput.click();
            logger.info("Added GPUS '" + addGPUs + "' selected");

            new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(GPUTypeInput))
                    .click();
            new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+GPUType+"')]/ancestor::li")))
                    .click();
            logger.info("GPU type '" + GPUType + "' selected");

            new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(numberOfGPUsInput))
                    .click();
            new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@aria-label, 'Number of GPUs')]//li[contains(@data-value, '"+numberOfGPUs+"')]")))
                    .click();
            logger.info("Number of GPUs '" + numberOfGPUs + "' selected");
            return this;
    }

    public PricingCalculatorPage waitForCostEvaluation(String cost) {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.textToBe(By.xpath("//div[contains(text(), 'Estimated cost')]/following-sibling::div/label"), cost));
        logger.info("Waited for cost '" + cost + "' evaluated");
        return this;
    }

    public PricingCalculatorPage openEstimateShare() {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-300);", openShareEstimate);
            new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@aria-label, 'Open Share Estimate dialog')]")));
            new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until((ExpectedConditions.elementToBeClickable(openShareEstimate)))
                    .click();
            logger.info("Open share estimate clicked");
            return this;
    }
    public EstimateSummaryPage openEstimateSummary() {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@track-name, 'open estimate summary')]")));
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until((ExpectedConditions.elementToBeClickable(openEstimateSummary)))
                .click();
        logger.info("Open estimate summary clicked");

        return new EstimateSummaryPage(webDriver);
    }
}
