package com.epam.training.student_oleksandra_kyrylchuk.task1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobject_model.pagefactory.page.PastebinGoogleVignettePage;
import pageobject_model.pagefactory.page.PostResultsPage;

import static junit.framework.TestCase.assertEquals;

public class WebDriverPastebinTest {
    WebDriver driver;
    @Test(description = "Creating and checking new paste")
    public void createAndCheckPaste() {
        driver = new FirefoxDriver();
        PastebinGoogleVignettePage googleVignettePage = new PastebinGoogleVignettePage(driver);
        googleVignettePage.openPage();
        String name = "helloweb", paste = "Hello from WebDriver";
        PostResultsPage postResultsPage = googleVignettePage.createNewPaste(paste, "10 Minutes", name);
        verifyPastedContent(postResultsPage, paste);
        verifyExpirationTime(postResultsPage, "10 MIN");
        verifyTitle(postResultsPage, name);
    }

    private void verifyPastedContent(PostResultsPage postResultsPage, String expectedPaste) {
        String actualPaste = postResultsPage.getPastes();
        assertEquals(expectedPaste, actualPaste);
    }

    private void verifyExpirationTime(PostResultsPage postResultsPage, String expectedExpiration) {
        String actualExpiration = postResultsPage.getExpiration();
        assertEquals(expectedExpiration, actualExpiration);
    }

    private void verifyTitle(PostResultsPage postResultsPage, String expectedTitle) {
        String actualTitle = postResultsPage.getNameOfHeader();
        assertEquals(expectedTitle, actualTitle);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
