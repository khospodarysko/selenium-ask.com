package com.lohika.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    @FindBy(id = "q")
    private WebElement searchInput;

    @FindBy(id = "sbut")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        log.info("Type text '{}' into search box", text);
        searchInput.sendKeys(text);
        log.info("Click 'Find Answers' button");
        searchButton.click();
    }
}
