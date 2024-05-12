package com.epam.training.student_oleksandra_kyrylchuk.task3;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject_model.pagefactory.page.*;


public class GoogleCloudPricingCalculatorTest {
    WebDriver driver;
    PricingCalculatorPage pricingCalculatorPage;
    EstimateSummaryPage estimateSummaryPage;
    @BeforeTest(description = "Google Cloud Pricing Calculator Initializing")
    private void setUp(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new FirefoxDriver(firefoxOptions);

        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudHomePage.openPage();
        googleCloudHomePage.clickSearchIcon();
        String query = "Google Cloud Pricing Calculator";
        GoogleCloudSearchPage googleCloudSearchPage = googleCloudHomePage.searchQuery(query);
        WelcomePricingCalculatorPage welcomePricingCalculatorPage = googleCloudSearchPage.openPricingCalculatorPage(query);
        welcomePricingCalculatorPage.addToEstimateClick();
        pricingCalculatorPage = welcomePricingCalculatorPage.computeEngineClick();

        int numberOfInstances = 4;
        String operationSystemSoftware = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
        String provisioningModel = "Regular";
        String machineFamily = "General Purpose";
        String series = "N1";
        String machineType = "n1-standard-8";
        boolean addGPUs = true;
        String GPUType = "NVIDIA Tesla V100";
        int numberOfGPUs = 1;
        String localSSD = "2x375 GB";
        String datacenterLocation = "South Carolina (us-east1)"; //There was no opportunity to choose Frankfurt
        String committedUsage = "1 year";

        pricingCalculatorPage.fillComputeEngineForm(numberOfInstances, operationSystemSoftware, provisioningModel, machineFamily,
                series, machineType, addGPUs, GPUType, numberOfGPUs, localSSD, datacenterLocation, committedUsage);
        pricingCalculatorPage.openEstimateShare();
        estimateSummaryPage = pricingCalculatorPage.openEstimateSummary();
    }
    @Test(description = "Google Cloud Pricing Calculator Testing")
    public void testGoogleCloudPricingCalculator() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Assert.assertEquals(estimateSummaryPage.getCostEstimateSummary(), "$19,096.38");
        Assert.assertEquals(estimateSummaryPage.getLocalSSD(), "2x375 GB");
        Assert.assertEquals(estimateSummaryPage.getCommittedUsage(), "1 year");
        Assert.assertEquals(estimateSummaryPage.getMachineType(), "n1-standard-8, vCPUs: 8, RAM: 30 GB");
        Assert.assertEquals(estimateSummaryPage.getNumberOfInstances(), "4");
        Assert.assertEquals(estimateSummaryPage.getDatacenterLocation(), "South Carolina (us-east1)");
        Assert.assertEquals(estimateSummaryPage.getProvisioningModel(), "Regular");
        Assert.assertEquals(estimateSummaryPage.getOperationSystemSoftware(), "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
