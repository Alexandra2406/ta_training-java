package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudSearchPage extends  AbstractPage{
    public GoogleCloudSearchPage(WebDriver webDriver) {
        super(webDriver);
    }
    public WelcomePricingCalculatorPage openPricingCalculatorPage(String query) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        WebElement openSearchLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[contains(text(), '" + query + "')]")));

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-300);", openSearchLink);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(openSearchLink)).click();
        } catch (ElementClickInterceptedException e) {
            logger.warn("Click intercepted, trying alternative methods...");

            Actions actions = new Actions(webDriver);
            actions.sendKeys(openSearchLink, Keys.TAB).build().perform();
        }
        logger.info("Google Cloud Pricing Calculator page opened");
        return new WelcomePricingCalculatorPage(webDriver);
    }
}
