package pageobject_model.pagefactory.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage {
    WebDriver webDriver;
    private final String HOMEPAGE_URL = "https://cloud.google.com";
    @FindBy(xpath = "//*[@id='kO001e']/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/div")
    WebElement searchIcon;
    @FindBy(xpath = "//*[@id='i4']")
    WebElement searchForm;

    public GoogleCloudHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudHomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public GoogleCloudHomePage clickSearchIcon() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(searchIcon))
                .click();
        return this;
    }
    public GoogleCloudSearchPage searchQuery(String query) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(searchForm));
        searchForm.sendKeys(query);
        searchForm.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchPage(webDriver);
    }
}
