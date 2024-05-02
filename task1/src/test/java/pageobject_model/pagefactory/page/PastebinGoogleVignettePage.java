package pageobject_model.pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PastebinGoogleVignettePage {
    private final String HOMEPAGE_URL = "https://pastebin.com/";
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"postform-text\"]")
    private WebElement postFormText;
    @FindBy(xpath = "//*[@id=\"select2-postform-expiration-container\"]")
    private WebElement postFormExpirationContainer;
    private WebElement expirationList;
    @FindBy(xpath = "//*[@id=\"select2-postform-format-container\"]")
    private WebElement postFormFormatContainer;
    //@FindBy(css = ".select2-search--dropdown > input")
    private WebElement formatInput;
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
    private PastebinGoogleVignettePage postFormTextSendKeys(String paste){
        postFormText.sendKeys(paste);
        return this;
    }
    private PastebinGoogleVignettePage postFormNameSendKeys(String name){
        postFormName.sendKeys(name);
        return this;
    }
    private PastebinGoogleVignettePage choosePasteExpiration(String expiration){
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(postFormExpirationContainer))
                .click();
        expirationList = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-postform-expiration-results\"]")));
        WebElement desiredOption = expirationList.findElement(By.xpath(".//li[text() = '" + expiration + "']"));
        desiredOption.click();
        return this;
    }
    private PastebinGoogleVignettePage choosePasteFormat(String syntaxHighlighting){
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(postFormFormatContainer))
                .click();
        formatInput = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-postform-format-results\"]/li[2]/ul")));
        List<WebElement> listItems = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//li[text() = '"+ syntaxHighlighting +"']")));
        listItems.get(0).click();
        return this;
    }
    private PostResultsPage clickCreateNewPasteButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", createNewPasteButton);

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createNewPasteButton))
                .click();
        return new PostResultsPage(webDriver);
    }
    public PostResultsPage createNewPaste(String paste, String expiration, String name){
        postFormTextSendKeys(paste);
        choosePasteExpiration(expiration);
        postFormNameSendKeys(name);
        return clickCreateNewPasteButton();
    }
    public PostResultsPage createNewPaste(String paste, String expiration, String name, String syntaxHighlighting){
        postFormTextSendKeys(paste);
        choosePasteExpiration(expiration);
        choosePasteFormat(syntaxHighlighting);
        postFormNameSendKeys(name);
        return clickCreateNewPasteButton();
    }
}
