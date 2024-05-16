package com.epam.training.student_oleksandra_kyrylchuk.test;

import com.epam.training.student_oleksandra_kyrylchuk.driver.DriverSingleton;
import com.epam.training.student_oleksandra_kyrylchuk.service.GoogleCloudPricingCalculatorService;
import com.epam.training.student_oleksandra_kyrylchuk.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public abstract class CommonConditions {

    protected WebDriver driver;
    protected GoogleCloudPricingCalculatorService calculatorService;

    @BeforeTest(alwaysRun = true)
    protected void setUp() {
        driver = DriverSingleton.getDriver();
        calculatorService = new GoogleCloudPricingCalculatorService(driver);
    }

    @AfterSuite(alwaysRun = true)
    protected void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
