package com.epam.training.student_oleksandra_kyrylchuk.task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobject_model.pagefactory.page.GoogleCloudHomePage;
import pageobject_model.pagefactory.page.GoogleCloudSearchPage;
import pageobject_model.pagefactory.page.PricingCalculatorPage;

public class GoogleCloudPricingCalculatorTest {
    WebDriver driver;
    @Test(description = "Google Cloud Pricing Calculator Testing")
    public void testGoogleCloudPricingCalculator() {
        driver = new FirefoxDriver();

        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudHomePage.openPage();
        googleCloudHomePage.clickSearchIcon();
        String query = "Google Cloud Pricing Calculator";
        GoogleCloudSearchPage googleCloudSearchPage = googleCloudHomePage.searchQuery(query);
        PricingCalculatorPage pricingCalculatorPage = googleCloudSearchPage.openSearchQuery(query, 1);
        pricingCalculatorPage.clickComputeEngine();
        fillComputeEngineForm(pricingCalculatorPage);
        testResultEstimateSummary(pricingCalculatorPage);
    }

    private void fillComputeEngineForm(PricingCalculatorPage pricingCalculatorPage){
        int numberOfInstances = 4;
        String operationSystemSoftware = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
        String provisioningModel = "Regular";
        String machineFamily = "General purpose";
        String series = "N1";
        String machineType = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
        boolean addGPUs = true;
        String GPUType = "NVIDIA Tesla V100";
        int numberOfGPUs = 1;
        String localSSD = "2x375 Gb";
        String datacenterLocation = "Frankfurt (europe-west3)";
        String committedUsage = "1 Year";

        pricingCalculatorPage.fillComputeEngineForm(numberOfInstances, operationSystemSoftware, provisioningModel, machineFamily,
                series, machineType, addGPUs, GPUType, numberOfGPUs, localSSD, datacenterLocation, committedUsage);
    }

    private void testResultEstimateSummary(PricingCalculatorPage pricingCalculatorPage){
        Assert.assertTrue(pricingCalculatorPage.openEstimateSummary());
        Assert.assertEquals(pricingCalculatorPage.getCostEstimateSummary(), "Total Estimated Cost: USD 1,081.20 per 1 month");
        Assert.assertEquals(pricingCalculatorPage.getLocalSSD(), "Local SSD: 2x375 GiB\n" + "Committed Use Discount applied");
        Assert.assertEquals(pricingCalculatorPage.getCommittedUsage(), "Commitment term: 1 Year");
        Assert.assertEquals(pricingCalculatorPage.getMachineType(), "Instance type: n1-standard-8\n" + "Committed Use Discount applied");
        Assert.assertEquals(pricingCalculatorPage.getNumberOfInstances(), "4 x");
        Assert.assertEquals(pricingCalculatorPage.getDatacenterLocation(), "Region: Frankfurt");
        Assert.assertEquals(pricingCalculatorPage.getProvisioningModel(), "Provisioning model: Regular");
        Assert.assertEquals(pricingCalculatorPage.getOperationSystemSoftware(), "Free");
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
