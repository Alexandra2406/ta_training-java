package pageobject_model.pagefactory.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobject_model.pagefactory.page.PastebinGoogleVignettePage;
import pageobject_model.pagefactory.page.PostResultsPage;

import static junit.framework.TestCase.assertEquals;

public class WebDriverPastebinTest {
    WebDriver driver;
    @Test(description = "Creating new paste")
    public void createPaste(){
        driver = new FirefoxDriver();
        PastebinGoogleVignettePage googleVignettePage = new PastebinGoogleVignettePage(driver);
        googleVignettePage.openPage();
        String name = "helloweb", paste = "Hello from WebDriver";
        PostResultsPage postResultsPage = googleVignettePage.createNewPaste(paste, "10 Minutes", name);

        assertEquals(paste, postResultsPage.getPastes());
        assertEquals("10 MIN", postResultsPage.getExpiration());
        assertEquals(name, postResultsPage.getNameOfHeader());
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
