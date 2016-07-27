package com.lohika;

import com.lohika.block.Result;
import com.lohika.page.HomePage;
import com.lohika.page.ResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchTest {
    private static final Logger log = LoggerFactory.getLogger(SearchTest.class);

    private StringBuilder allDescriptions = new StringBuilder();

    private WebDriver driver;
    private HomePage homePage;
    private ResultsPage resultsPage;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://ask.com");
    }

    @Test
    @Parameters({ "searchText" })
    public void test(@Optional("stub") String searchText) {
        homePage.search(searchText);

        List<Result> resultsPage1 = resultsPage.results();
        Assert.assertEquals(resultsPage1.size(), 10, "Received unexpected number of results on 1st page");
        resultsPage.printResults();
        for (Result r : resultsPage1) {
            allDescriptions.append(r.getDescription());
        }

        resultsPage.next();

        List<Result> resultsPage2 = resultsPage.results();
        Assert.assertEquals(resultsPage2.size(), 10, "Received unexpected number of results on 2nd page");
        resultsPage.printResults();
        for (Result r : resultsPage2) {
            allDescriptions.append(r.getDescription());
        }

        String s = allDescriptions.toString();
        Pattern p = Pattern.compile(searchText);
        Matcher m = p.matcher(s);
        int count = 0;
        while (m.find()) {
            count++;
        }
        log.info("Found {} occurrences of '{}' word", count, searchText);
    }
}
