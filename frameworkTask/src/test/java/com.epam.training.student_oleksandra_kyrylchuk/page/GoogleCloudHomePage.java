package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage extends AbstractPage {
    WebDriver webDriver;
    private final String HOMEPAGE_URL = "https://cloud.google.com";
    @FindBy(xpath = "//*[@id='kO001e']/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/div")
    WebElement searchIcon;
    @FindBy(xpath = "//*[@id='i4']")
    WebElement searchForm;

    public GoogleCloudHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleCloudHomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        logger.info("Google Cloud homepage opened");
        return this;
    }

    public GoogleCloudHomePage clickSearchIcon() {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchIcon))
                .click();
        logger.info("Search Icon clicked");
        return this;
    }
    public GoogleCloudSearchPage searchQuery(String query) {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(searchForm));
        searchForm.sendKeys(query);
        searchForm.sendKeys(Keys.ENTER);
        logger.info("Search request + '" + query + "' sent");
        return new GoogleCloudSearchPage(webDriver);
    }
}
