package hackathonv1;

import drivers.DriverFactory;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HackathonV1Page;
import utils.HackathonReporter;

public class TestBase {

  private static final Logger log = LoggerFactory.getLogger(TestBase.class.getName());

  WebDriver driver;
  HackathonReporter hackathonReporter;
  HackathonV1Page hackathonV1Page;

  @Parameters({"browser", "width", "height"})
  @BeforeTest
  void setUp(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height) {
    try {
      driver = DriverFactory.createBrowserInstance(browser, width, height);
      hackathonV1Page = new HackathonV1Page(driver);
    } catch (IOException e) {
      log.error(" :: Error creating driver instance -> " + e.getMessage());
    }
    driver.get("https://demo.applitools.com/gridHackathonV1.html");
  }

  @AfterTest
  void tearDown() {
    driver.quit();
  }
}
