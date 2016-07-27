package com.lohika.page;

import com.lohika.block.Result;
import com.lohika.block.ResultFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ResultsPage.class);

    @FindBy(css = ".js-pagination-next")
    private WebElement nextButton;

    @FindBy(css = ".wresult")
    private List<WebElement> resultElements;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public void next() {
        log.info("Click pagination 'Next' button");
        nextButton.click();
    }

    public List<Result> results() {
        log.info("Get results from current result page");
        List<Result> results = new ArrayList<>();
        for (WebElement e : resultElements) {
            results.add(ResultFactory.createResult(e));
        }
        return results;
    }

    public void printResults() {
        log.info("Print results from current result page");
        for (Result r : results()) {
            log.info("Link: [{}], Title: [{}], Description: [{}]", r.getLink(), r.getTitle(), r.getDescription());
        }
    }
}
