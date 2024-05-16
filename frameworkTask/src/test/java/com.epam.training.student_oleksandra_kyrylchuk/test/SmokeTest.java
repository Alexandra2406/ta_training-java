package com.epam.training.student_oleksandra_kyrylchuk.test;

import com.epam.training.student_oleksandra_kyrylchuk.page.PricingCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends CommonConditions{
    @Test(description = "Smoke test")
    public void shouldGetPricingCalculatorPage() {
        calculatorService.getPricingCalculatorPageFromSearchResults();
        Assert.assertTrue(driver.getCurrentUrl().contains(PricingCalculatorPage.getHOMEPAGE_URL()),
                "got the wrong page from the first position in the search results");
    }
}
