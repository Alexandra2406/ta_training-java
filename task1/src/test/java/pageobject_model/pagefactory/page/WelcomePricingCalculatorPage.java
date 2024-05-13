package pageobject_model.pagefactory.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePricingCalculatorPage {
    WebDriver webDriver;
    @FindBy(xpath = "//c-wiz[1]//button")
    WebElement addToEstimateButton;
    @FindBy(xpath = "//div[h2/text()='Compute Engine']")
    WebElement computeEngineButton;

    public WelcomePricingCalculatorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public WelcomePricingCalculatorPage addToEstimateClick(){
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(addToEstimateButton));
        Actions actions = new Actions(webDriver);
        actions.sendKeys(addToEstimateButton, Keys.TAB).build().perform();
        return this;
    }
    public PricingCalculatorPage computeEngineClick(){
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(computeEngineButton));
        Actions actions = new Actions(webDriver);
        actions.sendKeys(computeEngineButton, Keys.TAB).build().perform();
        return new PricingCalculatorPage(webDriver);
    }
}
