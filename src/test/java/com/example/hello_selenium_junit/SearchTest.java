package com.example.hello_selenium_junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchTest {
    private WebDriver driver;
    private String browser;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(System.getProperty("browser"));
        //capabilities.setCapability("browserName",  "firefox");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        //open("about:blank");
        //driver = getWebDriver(this.browser);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }



    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void googlesearch() {
        // Test name: google-search
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://www.google.es/");
        // 2 | setWindowSize | 843x774 |
        driver.manage().window().setSize(new Dimension(843, 774));
        // 3 | selectFrame | name=q |
        //{
        //    WebElement element = driver.findElement(By.name("q"));
        //    driver.switchTo().frame(element);
        //}
        driver.switchTo().frame(0);
        // 4 | click | css=#introAgreeButton .RveJvd |
        driver.findElement(By.cssSelector("#introAgreeButton .RveJvd")).click();
        // 5 | selectFrame | relative=parent |
        driver.switchTo().defaultContent();
        // 6 | type | name=q | selenium
        driver.findElement(By.name("q")).sendKeys("selenium");
        // 7 | sendKeys | name=q | ${KEY_ENTER}
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        // 8 | click | xpath=//span[contains(.,'Selenium WebDriver')] |
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//span[contains(.,\'Selenium WebDriver\')]")).click();
    }
}
