package com.lohika.block;

import org.openqa.selenium.WebElement;

public class ResultFactory {
    public static Result createResult(WebElement element) {
        if (element.getAttribute("class").contains("tsrc_SAS")) {
            return new DictionaryResult(element);
        }
        if (element.getAttribute("class").contains("tsrc_NEWS")) {
            return new NewsResult(element);
        }
        return new SimpleResult(element);
    }
}
