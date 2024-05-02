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

    @Test(description = "Creating new paste")
    public void createPaste(){
        driver = new FirefoxDriver();
        PastebinGoogleVignettePage googleVignettePage = new PastebinGoogleVignettePage(driver);
        googleVignettePage.openPage();
        String name = "how to gain dominance among developers";
        String paste = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String syntaxHighlighting = "Bash";
        PostResultsPage postResultsPage = googleVignettePage.createNewPaste(paste, "10 Minutes", name, syntaxHighlighting);
        assertEquals(paste, postResultsPage.getPastes());
        assertEquals("10 MIN", postResultsPage.getExpiration());
        assertEquals(name, postResultsPage.getNameOfHeader());
        assertEquals(syntaxHighlighting, postResultsPage.getFormat());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
