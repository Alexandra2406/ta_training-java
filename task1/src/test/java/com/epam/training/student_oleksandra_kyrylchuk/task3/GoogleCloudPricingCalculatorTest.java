package com.epam.training.student_oleksandra_kyrylchuk.task3;

import com.epam.training.student_oleksandra_kyrylchuk.task3.data.PricingCalculatorTestData;
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
    public Object[] testData() {
        return new PricingCalculatorTestData[]{
               new PricingCalculatorTestData(4, "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)",
                        "Regular", "General Purpose", "N1", "n1-standard-8, vCPUs: 8, RAM: 30 GB", true, "NVIDIA Tesla V100", 1,
                        "2x375 GB", "South Carolina (us-east1)", "1 year", "$5,413.26", "n1-standard-8")
        };
    }
    @BeforeTest(description = "Google Cloud Pricing Calculator Initializing")
    private void setUp(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new FirefoxDriver(firefoxOptions);
    }
    @Test(description = "Google Cloud Pricing Calculator Testing", dataProvider = "testData")
    public void testGoogleCloudPricingCalculatorSetUp(PricingCalculatorTestData pricingCalculatorTD) {
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudHomePage.openPage();
        googleCloudHomePage.clickSearchIcon();
        String query = "Google Cloud Pricing Calculator";
        GoogleCloudSearchPage googleCloudSearchPage = googleCloudHomePage.searchQuery(query);
        WelcomePricingCalculatorPage welcomePricingCalculatorPage = googleCloudSearchPage.openPricingCalculatorPage(query);
        welcomePricingCalculatorPage.addToEstimateClick();
        pricingCalculatorPage = welcomePricingCalculatorPage.computeEngineClick();

        pricingCalculatorPage.fillComputeEngineForm(pricingCalculatorTD.getNumberOfInstances(), pricingCalculatorTD.getOperationSystemSoftware(),
                pricingCalculatorTD.getProvisioningModel(), pricingCalculatorTD.getMachineFamily(), pricingCalculatorTD.getSeries(),
                pricingCalculatorTD.getMachineTypeSetUp(), pricingCalculatorTD.isAddGPUs(), pricingCalculatorTD.getGPUType(),
                pricingCalculatorTD.getNumberOfGPUs(), pricingCalculatorTD.getLocalSSD(), pricingCalculatorTD.getDatacenterLocation(),
                pricingCalculatorTD.getCommittedUsage(), pricingCalculatorTD.getCost());
        pricingCalculatorPage.openEstimateShare();
        estimateSummaryPage = pricingCalculatorPage.openEstimateSummary();
    }
    @Test(priority = 1, description = "Google Cloud Pricing Calculator Testing", dataProvider = "testData")
    public void testGoogleCloudPricingCalculator(PricingCalculatorTestData pricingCalculatorTD) {
        estimateSummaryPage.switchToNewWindow();
        Assert.assertEquals(estimateSummaryPage.getCostEstimateSummary(), pricingCalculatorTD.getCost());
        Assert.assertEquals(estimateSummaryPage.getLocalSSD(), pricingCalculatorTD.getLocalSSD());
        Assert.assertEquals(estimateSummaryPage.getCommittedUsage(), pricingCalculatorTD.getCommittedUsage());
        Assert.assertEquals(estimateSummaryPage.getMachineType(), pricingCalculatorTD.getMachineType());
        Assert.assertEquals(estimateSummaryPage.getNumberOfInstances(), String.valueOf(pricingCalculatorTD.getNumberOfInstances()));
        Assert.assertEquals(estimateSummaryPage.getNumberOfGPUs(), String.valueOf(pricingCalculatorTD.getNumberOfGPUs()));
        Assert.assertEquals(estimateSummaryPage.getGPUModel(), pricingCalculatorTD.getGPUType());
        Assert.assertEquals(estimateSummaryPage.getDatacenterLocation(), pricingCalculatorTD.getDatacenterLocation());
        Assert.assertEquals(estimateSummaryPage.getProvisioningModel(), pricingCalculatorTD.getProvisioningModel());
        Assert.assertEquals(estimateSummaryPage.getOperationSystemSoftware(), pricingCalculatorTD.getOperationSystemSoftware());
    }
    @AfterSuite(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

}
