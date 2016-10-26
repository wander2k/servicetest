package llk.hearst.cosmotw.service.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

// https://thetower.atlassian.net/browse/WOLVERINE-784
public class FacebookUnfoldCommentsTest extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public void setUp() throws Exception {
    FirefoxProfile profile = new FirefoxProfile();
    profile.setPreference("network.http.phishy-userpass-length", 255);
    driver = new FirefoxDriver(profile);

    baseUrl = "http://lingkun.li:Llk228510@cosmotw.hmitech.io/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public void testCosmotwIoFBUnfold() throws Exception {
    driver.get(baseUrl + "/");

    //WebDriverWait wait = new WebDriverWait(driver, 10);
//    wait.until(ExpectedConditions.alertIsPresent());
//
//
//    Credentials
//    Alert
    // wait.until(ExpectedConditions.alertIsPresent());
    //alert.authenticateUsing(new UserAndPassword(**username**, **password**));

    // ERROR: Caught exception [ERROR: Unsupported command [createCookie | nsghtn=dev | ]]
    driver.get(baseUrl + "/");

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homepage")));
    //wait.wait(5);

    Cookie cookie = new Cookie("nsghtn", "dev");
    driver.manage().addCookie(cookie);


    driver.findElement(By.xpath("//a[contains(text(),'25歲前要養出讓男人對妳著迷的好習慣 姐立志當個不膩的女人')]")).click();
    assertEquals("dev", driver.manage().getCookieNamed("nsghtn").getValue());
    // ERROR: Caught exception [ERROR: Unsupported command [getCookieByName | nsghtn | ]]
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("article")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("comments-container--standard-article")));

    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("button.module-comments--toggle"), "隱藏留言"));

    //assertEquals(, driver.findElement().getText());
  }

  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
