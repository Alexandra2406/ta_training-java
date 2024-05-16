package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EstimateSummaryPage extends AbstractPage{
    public EstimateSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }
    public EstimateSummaryPage switchToNewWindow(){
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
        logger.info("WebDriver switched to last window");
        return this;
    }
    public String getCostEstimateSummary() {
        logger.info("Getting total estimated cost");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Total estimated cost')]/following-sibling::h4")))
                .getText().strip();
    }
    public String getNumberOfInstances(){
        logger.info("Getting number of instances");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Number of Instances')]/following-sibling::span")))
                .getText().strip();
    }
    public String getOperationSystemSoftware(){
        logger.info("Getting operation system software");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Operating System / Software')]/following-sibling::span")))
                .getText().strip();
    }
    public String getProvisioningModel(){
        logger.info("Getting provision model");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Provisioning Model')]/following-sibling::span")))
                .getText().strip();
    }
    public String getMachineType(){
        logger.info("Getting machine type");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Machine type')]/following-sibling::span")))
                .getText().strip();
    }
    public String getLocalSSD(){
        logger.info("Getting local SSD");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Local SSD')]/following-sibling::span")))
                .getText().strip();
    }
    public String getDatacenterLocation(){
        logger.info("Getting datacenter location");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Region')]/following-sibling::span")))
                .getText().strip();
    }
    public String getCommittedUsage(){
        logger.info("Getting committed usage");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Committed use discount options')]/following-sibling::span")))
                .getText().strip();
    }
    public String getNumberOfGPUs(){
        logger.info("Getting number of GPUs");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Number of GPUs')]/following-sibling::span")))
                .getText().strip();
    }
    public String getGPUModel(){
        logger.info("Getting GPU model");
        return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'GPU Model')]/following-sibling::span")))
                .getText().strip();
    }
}
