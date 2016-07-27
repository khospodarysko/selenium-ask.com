package com.lohika.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SimpleResult implements Result {
    private WebElement wrapperElement;

    public SimpleResult(WebElement element) {
        wrapperElement = element;
    }

    @Override
    public String getLink() {
        return wrapperElement.findElement(By.cssSelector(".durl .txt3")).getText();
    }

    @Override
    public String getTitle() {
        return wrapperElement.findElement(By.cssSelector(".title.txt_lg")).getText();
    }

    @Override
    public String getDescription() {
        return wrapperElement.findElement(By.cssSelector(".abstract.txt3")).getText();
    }
}
