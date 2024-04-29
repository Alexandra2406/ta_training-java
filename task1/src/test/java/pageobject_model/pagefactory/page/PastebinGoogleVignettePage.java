package pageobject_model.pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PastebinGoogleVignettePage {
    private final String HOMEPAGE_URL = "https://pastebin.com/";
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"postform-text\"]")
    private WebElement postFormText;
    @FindBy(xpath = "//*[@id=\"select2-postform-expiration-container\"]")
    private WebElement postFormExpirationContainer;
    private WebElement expirationList;
    @FindBy(xpath = "//*[@id=\"postform-name\"]")
    private WebElement postFormName;
    @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button")
    private WebElement createNewPasteButton;


    public PastebinGoogleVignettePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public PastebinGoogleVignettePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        PageFactory.initElements(webDriver, this);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        return this;
    }
    public PostResultsPage createNewPaste(String paste, String expiration, String name){
        postFormText.sendKeys(paste);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(postFormExpirationContainer))
                .click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        expirationList = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-postform-expiration-results\"]")));
        WebElement desiredOption = expirationList.findElement(By.xpath(".//li[text() = '" + expiration + "']"));
        desiredOption.click();

        postFormName.sendKeys(name);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createNewPasteButton))
                .click();
        return new PostResultsPage(webDriver);
    }

}
