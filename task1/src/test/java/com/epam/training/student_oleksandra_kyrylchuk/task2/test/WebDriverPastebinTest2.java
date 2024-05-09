package com.epam.training.student_oleksandra_kyrylchuk.task2.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobject_model.pagefactory.page.PastebinGoogleVignettePage;
import pageobject_model.pagefactory.page.PostResultsPage;

import static junit.framework.TestCase.assertEquals;

public class WebDriverPastebinTest2 {
    WebDriver driver;

    @Test(description = "Creating and checking new paste")
    public void createAndCheckPaste(){
        driver = new FirefoxDriver();
        PastebinGoogleVignettePage googleVignettePage = new PastebinGoogleVignettePage(driver);
        googleVignettePage.openPage();
        String name = "how to gain dominance among developers";
        String paste = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String syntaxHighlighting = "Bash";
        String expectedExpiration = "10 MIN";
        PostResultsPage postResultsPage = googleVignettePage.createNewPaste(paste, "10 Minutes", name, syntaxHighlighting);
        verifyPastedContent(postResultsPage, paste);
        verifyExpirationTime(postResultsPage, expectedExpiration);
        verifyTitle(postResultsPage, name);
        verifyFormat(postResultsPage, syntaxHighlighting);
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
    private void verifyFormat(PostResultsPage postResultsPage, String syntaxHighlighting) {
        String actualSyntaxHighlighting = postResultsPage.getFormat();
        assertEquals(syntaxHighlighting, actualSyntaxHighlighting);
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
