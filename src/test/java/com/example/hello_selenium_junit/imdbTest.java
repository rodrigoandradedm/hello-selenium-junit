package com.example.hello_selenium_junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class imdbTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void imdbwandavision() {
        driver.get("https://www.imdb.com/");
        //driver.manage().window().setSize(new Dimension(843, 776));
        driver.findElement(By.id("suggestion-search")).sendKeys("wandavision");
        driver.findElement(By.id("suggestion-search")).sendKeys(Keys.ENTER);
        WebElement wandaresult = new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),\'WandaVision\')]")));
        driver.findElement(By.linkText("WandaVision")).click();
    }
}
