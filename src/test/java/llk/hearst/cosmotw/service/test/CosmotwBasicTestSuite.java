package llk.hearst.cosmotw.service.test;
import junit.framework.Test;
import junit.framework.TestSuite;

public class CosmotwBasicTestSuite extends junit.framework.TestSuite{

  public static Test suite() {
	  System.setProperty("webdriver.gecko.driver", "C:\\mywork\\Selenium\\geckodriver.exe");
//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaneko\\workspace\\Selenium\\ThirdPartyDriver\\chromedriver.exe");
//	System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
//	System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");


    TestSuite suite = new TestSuite();
    suite.addTestSuite(FacebookUnfoldCommentsTest.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}
