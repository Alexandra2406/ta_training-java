package pageobject_model.pagefactory.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleCloudSearchPage {
    WebDriver webDriver;
    public GoogleCloudSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public PricingCalculatorPageLegacy openPricingCalculatorPageLegacy(String query) {

       WebElement openSearchLink = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(), '" + query + "')]")))
                .get(1);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-300);", openSearchLink);
        openSearchLink.click();

        return new PricingCalculatorPageLegacy(webDriver);
    }
    public WelcomePricingCalculatorPage openPricingCalculatorPage(String query) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement openSearchLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[contains(text(), '" + query + "')]")));

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-300);", openSearchLink);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(openSearchLink)).click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted, trying alternative methods...");

            Actions actions = new Actions(webDriver);
            actions.sendKeys(openSearchLink, Keys.TAB).build().perform();
        }

        return new WelcomePricingCalculatorPage(webDriver);
    }
}
