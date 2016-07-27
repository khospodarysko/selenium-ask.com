package com.lohika.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Explanation of what is considered to be a news result could be found in {@link ResultFactory#createResult}
 */
public class NewsResult implements Result {
    private WebElement wrapperElement;

    public NewsResult(WebElement element) {
        wrapperElement = element;
    }

    @Override
    public String getLink() {
        return wrapperElement.findElement(By.cssSelector(".news-result-item-url")).getText();
    }

    @Override
    public String getTitle() {
        return wrapperElement.findElement(By.cssSelector(".web-result-title-link")).getText();
    }

    @Override
    public String getDescription() {
        return wrapperElement.findElement(By.cssSelector(".news-result-item-link")).getText();
    }
}
