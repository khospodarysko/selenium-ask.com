package com.lohika.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Explanation of what is considered to be a dictionary result could be found in {@link ResultFactory#createResult}
 */
public class DictionaryResult implements Result {
    private WebElement wrapperElement;

    public DictionaryResult(WebElement element) {
        wrapperElement = element;
    }

    @Override
    public String getLink() {
        return wrapperElement.findElement(By.cssSelector(".sa_site_attr")).getText();
    }

    @Override
    public String getTitle() {
        return wrapperElement.findElement(By.cssSelector(".sa_dictionary_syllable_spell")).getText();
    }

    @Override
    public String getDescription() {
        return wrapperElement.findElement(By.cssSelector(".sa_dictionary_definitions")).getText();
    }
}