package com.epam.training.student_oleksandra_kyrylchuk.test;

import com.epam.training.student_oleksandra_kyrylchuk.model.ComputeEngine;
import com.epam.training.student_oleksandra_kyrylchuk.page.EstimateSummaryPage;
import com.epam.training.student_oleksandra_kyrylchuk.page.PricingCalculatorPage;
import com.epam.training.student_oleksandra_kyrylchuk.service.ComputeEngineCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorAllTest extends CommonConditions{
    PricingCalculatorPage pricingCalculatorPage;
    EstimateSummaryPage estimateSummaryPage;
    ComputeEngine computeEngine;
    @Test(description = "Initialize and fill Google Cloud Pricing Calculator Page Test")
    public void initializeAndFillPricingCalculatorPage() {
        pricingCalculatorPage = calculatorService.getPricingCalculatorPageFromSearchResults();
        Assert.assertTrue(driver.getCurrentUrl().contains(PricingCalculatorPage.getHOMEPAGE_URL()),
                "got the wrong page");
        computeEngine = ComputeEngineCreator.withDataFromProperty();
        calculatorService.addComputeEngineToEstimate(pricingCalculatorPage, computeEngine);

    }
    @Test(priority = 1, description = "Check estimated cost")
    public void estimatedCostTest() {
        Assert.assertEquals(estimateSummaryPage.getCostEstimateSummary(), computeEngine.getCost());
    }
    @Test(priority = 1, description = "Check local SSD")
    public void localSSDTest() {
        Assert.assertEquals(estimateSummaryPage.getLocalSSD(), computeEngine.getLocalSSD());
    }
    @Test(priority = 1, description = "Check committed usage")
    public void committedUsageTest() {
        Assert.assertEquals(estimateSummaryPage.getCommittedUsage(), computeEngine.getCommittedUsage());
    }
    @Test(priority = 1, description = "Check machine type")
    public void machineTypeTest() {
        Assert.assertEquals(estimateSummaryPage.getMachineType(), computeEngine.getMachineType());
    }
    @Test(priority = 1, description = "Check number of instances")
    public void numberOfInstancesTest() {
        Assert.assertEquals(estimateSummaryPage.getNumberOfInstances(), String.valueOf(computeEngine.getNumberOfInstances()));
    }
    @Test(priority = 1, description = "Check number of GPUs")
    public void numberOfGPUsTest() {
        if (computeEngine.isAddGPUs()){
            Assert.assertEquals(estimateSummaryPage.getNumberOfGPUs(), String.valueOf(computeEngine.getNumberOfGPUs()));
        }
    }
    @Test(priority = 1, description = "Check GPU model")
    public void gpuModelTest() {
        if (computeEngine.isAddGPUs()) {
            Assert.assertEquals(estimateSummaryPage.getGPUModel(), computeEngine.getGPUType());
        }
    }
    @Test(priority = 1, description = "Check datacenter location")
    public void datacenterLocationTest() {
        Assert.assertEquals(estimateSummaryPage.getDatacenterLocation(), computeEngine.getDatacenterLocation());
    }
    @Test(priority = 1, description = "Check provision model")
    public void provisionModelTest() {
        Assert.assertEquals(estimateSummaryPage.getProvisioningModel(), computeEngine.getProvisioningModel());
    }
    @Test(priority = 1, description = "Check operation system software")
    public void operationSystemSoftwareTest() {
        Assert.assertEquals(estimateSummaryPage.getOperationSystemSoftware(), computeEngine.getOperationSystemSoftware());
    }
}
