package pageobject_model.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PostResultsPage {
    WebDriver webDriver;
    @FindBy(className = "de1")
    List<WebElement> pastes;
    @FindBy(xpath = "//div[@class='info-top']/h1")
    WebElement header;
    @FindBy(xpath = "//div[@class='expire']\n")
    WebElement expire;
    public PostResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public String getPastes(){
        StringBuilder combinedText = new StringBuilder();

        for (WebElement paste : pastes) {
            combinedText.append(paste.getText().trim()).append(" ");
        }

        combinedText.deleteCharAt(combinedText.length() - 1);
        return combinedText.toString();
    }
    public String getNameOfHeader(){
        return header.getText().trim();
    }
    public String getExpiration(){
        return expire.getText().trim();
    }
}
