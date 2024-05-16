package com.epam.training.student_oleksandra_kyrylchuk.service;

import com.epam.training.student_oleksandra_kyrylchuk.model.ComputeEngine;
import com.epam.training.student_oleksandra_kyrylchuk.page.EstimateSummaryPage;
import com.epam.training.student_oleksandra_kyrylchuk.page.GoogleCloudHomePage;
import com.epam.training.student_oleksandra_kyrylchuk.page.PricingCalculatorPage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudPricingCalculatorService {
    private static final String SEARCH_TERM = "Google Cloud Pricing Calculator";

    private final WebDriver driver;

    public GoogleCloudPricingCalculatorService(WebDriver driver) {
        this.driver = driver;
    }

    public PricingCalculatorPage getPricingCalculatorPageFromSearchResults() {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .clickSearchIcon()
                .searchQuery(SEARCH_TERM)
                .openPricingCalculatorPage(SEARCH_TERM)
                .addToEstimateClick()
                .computeEngineClick();
    }

    public EstimateSummaryPage addComputeEngineToEstimate(PricingCalculatorPage pricingCalculatorPage,
                                                          ComputeEngine computeEngine) {
        pricingCalculatorPage.fillComputeEngineForm(computeEngine.getNumberOfInstances(), computeEngine.getOperationSystemSoftware(),
                computeEngine.getProvisioningModel(), computeEngine.getMachineFamily(), computeEngine.getSeries(),
                computeEngine.getMachineTypeSetUp(), computeEngine.getLocalSSD(), computeEngine.getDatacenterLocation(),
                computeEngine.getCommittedUsage());
        if (computeEngine.getNumberOfGPUs() > 0) {
            pricingCalculatorPage.addGPUs(computeEngine.isAddGPUs(), computeEngine.getGPUType(), computeEngine.getNumberOfGPUs());
        }
        return pricingCalculatorPage
                .waitForCostEvaluation(computeEngine.getCost())
                .openEstimateShare()
                .openEstimateSummary()
                .switchToNewWindow();
    }
}
