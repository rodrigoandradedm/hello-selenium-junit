// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class RobobarTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    FirefoxOptions options = new FirefoxOptions();
    options.setHeadless(true);
    driver = new FirefoxDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void robobar() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(843, 777));
    driver.findElement(By.xpath("//div[2]/button")).click();
    driver.findElement(By.xpath("//tr[2]/td[3]/div/div/div[2]/button")).click();
    driver.findElement(By.cssSelector(".ng-scope:nth-child(3) .input-group-append > .btn")).click();
    vars.put("total", driver.findElement(By.xpath("//tr[4]/th[2]")).getText());
    assertEquals(vars.get("total").toString(), "€6.25");
  }
}
