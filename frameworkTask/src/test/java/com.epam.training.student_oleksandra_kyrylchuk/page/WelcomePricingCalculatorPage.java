package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePricingCalculatorPage extends AbstractPage{

    @FindBy(xpath = "//c-wiz[1]//button")
    WebElement addToEstimateButton;
    @FindBy(xpath = "//div[h2/text()='Compute Engine']")
    WebElement computeEngineButton;
    protected WelcomePricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }
    public WelcomePricingCalculatorPage addToEstimateClick(){
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(addToEstimateButton));
        Actions actions = new Actions(webDriver);
        actions.sendKeys(addToEstimateButton, Keys.TAB).build().perform();
        logger.info("Add to estimate clicked");
        return this;
    }
    public PricingCalculatorPage computeEngineClick(){
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(computeEngineButton));
        Actions actions = new Actions(webDriver);
        actions.sendKeys(computeEngineButton, Keys.TAB).build().perform();
        logger.info("Compute engine clicked");
        return new PricingCalculatorPage(webDriver);
    }
}
