package pageobject_model.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PostResultsPage {
    WebDriver webDriver;
    @FindBy(className = "de1")
    List<WebElement> pastes;
    @FindBy(xpath = "//div[@class='info-top']/h1")
    WebElement header;
    @FindBy(xpath = "//div[@class='expire']\n")
    WebElement expire;
    @FindBy(css = "div.left > a.btn.-small.h_800")
    WebElement format;
    public PostResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String getPastes(){
        StringBuilder combinedText = new StringBuilder();
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfAllElements(pastes));
        for (WebElement paste : pastes) {
            combinedText.append(paste.getText().trim()).append("\n");
        }

        combinedText.deleteCharAt(combinedText.length() - 1);
        return combinedText.toString();
    }
    public String getNameOfHeader(){
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(header));
        return header.getText().trim();
    }
    public String getExpiration(){
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(expire));
        return expire.getText().trim();
    }
    public String getFormat(){
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(format));
       return format.getText().trim();
    }
}
