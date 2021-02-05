package com.example.hello_selenium_junit;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RobobarTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName",  "chrome");
    driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void robobar() {
    driver.get("http://10.250.14.1:3000");
    driver.manage().window().setSize(new Dimension(843, 777));
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.xpath("//div[2]/button")).click();
    driver.findElement(By.xpath("//tr[2]/td[3]/div/div/div[2]/button")).click();
    driver.findElement(By.cssSelector(".ng-scope:nth-child(3) .input-group-append > .btn")).click();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    vars.put("total", driver.findElement(By.xpath("//tr[4]/th[2]")).getText());
    assertEquals(vars.get("total").toString(), "€6.25");
  }
}
