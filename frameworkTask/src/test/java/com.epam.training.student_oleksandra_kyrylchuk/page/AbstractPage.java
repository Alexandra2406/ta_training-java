package com.epam.training.student_oleksandra_kyrylchuk.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


public class AbstractPage {

    protected WebDriver webDriver;
    protected final Logger logger = LogManager.getRootLogger();
    protected Capabilities cap;
    protected String browserName;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        cap = ((RemoteWebDriver) webDriver).getCapabilities();
        browserName = cap.getBrowserName().toLowerCase();
        PageFactory.initElements(webDriver, this);
    }
}
