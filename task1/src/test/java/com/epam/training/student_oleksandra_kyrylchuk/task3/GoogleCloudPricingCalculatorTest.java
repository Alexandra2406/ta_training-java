package com.epam.training.student_oleksandra_kyrylchuk.task3;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject_model.pagefactory.page.*;


public class GoogleCloudPricingCalculatorTest {
    WebDriver driver;
    PricingCalculatorPage pricingCalculatorPage;
    EstimateSummaryPage estimateSummaryPage;
    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][] {
                {4, "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)",
                        "Regular", "General Purpose", "N1", "n1-standard-8, vCPUs: 8, RAM: 30 GB", true, "NVIDIA Tesla V100", 1,
                        "2x375 GB", "South Carolina (us-east1)", "1 year", "$5,413.26", "n1-standard-8"}
        };
    }
    @BeforeTest(description = "Google Cloud Pricing Calculator Initializing")
    private void setUp(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new FirefoxDriver(firefoxOptions);
    }
    @Test(priority = 0, description = "Google Cloud Pricing Calculator Testing", dataProvider = "testData")
    public void testGoogleCloudPricingCalculatorSetUp(int numberOfInstances, String operationSystemSoftware,
                                                 String provisioningModel, String machineFamily, String series,
                                                 String machineType, boolean addGPUs, String GPUType, int numberOfGPUs,
                                                 String localSSD, String datacenterLocation, String committedUsage, String cost, String machineTypeSetUp) {
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudHomePage.openPage();
        googleCloudHomePage.clickSearchIcon();
        String query = "Google Cloud Pricing Calculator";
        GoogleCloudSearchPage googleCloudSearchPage = googleCloudHomePage.searchQuery(query);
        WelcomePricingCalculatorPage welcomePricingCalculatorPage = googleCloudSearchPage.openPricingCalculatorPage(query);
        welcomePricingCalculatorPage.addToEstimateClick();
        pricingCalculatorPage = welcomePricingCalculatorPage.computeEngineClick();

        pricingCalculatorPage.fillComputeEngineForm(numberOfInstances, operationSystemSoftware, provisioningModel, machineFamily,
                series, machineTypeSetUp, addGPUs, GPUType, numberOfGPUs, localSSD, datacenterLocation, committedUsage, cost);
        pricingCalculatorPage.openEstimateShare();
        estimateSummaryPage = pricingCalculatorPage.openEstimateSummary();
    }
    @Test(priority = 1, description = "Google Cloud Pricing Calculator Testing", dataProvider = "testData")
    public void testGoogleCloudPricingCalculator(int numberOfInstances, String operationSystemSoftware,
                                                 String provisioningModel, String machineFamily, String series,
                                                 String machineType, boolean addGPUs, String GPUType, int numberOfGPUs,
                                                 String localSSD, String datacenterLocation, String committedUsage, String cost, String machineTypeSetUp) {
        estimateSummaryPage.switchToNewWindow();
        Assert.assertEquals(estimateSummaryPage.getCostEstimateSummary(), cost);
        Assert.assertEquals(estimateSummaryPage.getLocalSSD(), localSSD);
        Assert.assertEquals(estimateSummaryPage.getCommittedUsage(), committedUsage);
        Assert.assertEquals(estimateSummaryPage.getMachineType(), machineType);
        Assert.assertEquals(estimateSummaryPage.getNumberOfInstances(), String.valueOf(numberOfInstances));
        Assert.assertEquals(estimateSummaryPage.getNumberOfGPUs(), String.valueOf(numberOfGPUs));
        Assert.assertEquals(estimateSummaryPage.getGPUModel(), GPUType);
        Assert.assertEquals(estimateSummaryPage.getDatacenterLocation(), datacenterLocation);
        Assert.assertEquals(estimateSummaryPage.getProvisioningModel(), provisioningModel);
        Assert.assertEquals(estimateSummaryPage.getOperationSystemSoftware(), operationSystemSoftware);
    }
    @AfterSuite(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

}
