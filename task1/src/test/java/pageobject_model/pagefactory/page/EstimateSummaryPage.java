package pageobject_model.pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EstimateSummaryPage {
    WebDriver webDriver;
    public EstimateSummaryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String getCostEstimateSummary() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Total estimated cost')]/following-sibling::h4")))
                .getText().strip();
    }
    public String getNumberOfInstances(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Number of Instances')]/following-sibling::span")))
                .getText().strip();
    }
    public String getOperationSystemSoftware(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Operating System / Software')]/following-sibling::span")))
                .getText().strip();
    }
    public String getProvisioningModel(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Provisioning Model')]/following-sibling::span")))
                .getText().strip();
    }
    public String getMachineType(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Machine type')]/following-sibling::span")))
                .getText().strip();
    }
    public String getLocalSSD(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Local SSD')]/following-sibling::span")))
                .getText().strip();
    }
    public String getDatacenterLocation(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Region')]/following-sibling::span")))
                .getText().strip();
    }
    public String getCommittedUsage(){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Committed use discount options')]/following-sibling::span")))
                .getText().strip();
    }
}
