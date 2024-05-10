package pageobject_model.pagefactory.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleCloudSearchPage {
    WebDriver webDriver;
    public GoogleCloudSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public PricingCalculatorPage openSearchQuery(String query, int number) {

       WebElement openSearchLink = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(), '" + query + "')]")))
                .get(number);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-300);", openSearchLink);
        openSearchLink.click();

        return new PricingCalculatorPage(webDriver);
    }
}
