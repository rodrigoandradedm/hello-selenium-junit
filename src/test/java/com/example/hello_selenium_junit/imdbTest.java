package com.example.hello_selenium_junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class imdbTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName",  "firefox");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
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
