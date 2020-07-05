package hackathonv2;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Optional;
import traditionalv2.drivers.DriverFactory;
import traditionalv2.pages.HackathonV2Page;
import traditionalv2.utils.HackathonReporter;

public class TestBase {

  private static final Logger log = LoggerFactory.getLogger(TestBase.class.getName());

  WebDriver driver;
  HackathonReporter hackathonReporter;
  HackathonV2Page hackathonV2Page;

  public WebDriver getDriver() {
    return driver;
  }

  public HackathonReporter getHackathonReporter() {
    hackathonReporter = new HackathonReporter();
    return hackathonReporter;
  }

  public HackathonV2Page getHackathonV2Page() {
    hackathonV2Page = new HackathonV2Page(driver);
    return hackathonV2Page;
  }

  void setUp(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height) {
    try {
      driver = DriverFactory.createBrowserInstance(browser, width, height);
      hackathonV2Page = new HackathonV2Page(driver);
    } catch (IOException e) {
      log.error(" :: Error creating driver instance -> " + e.getMessage());
    }
    driver.get("https://demo.applitools.com/gridHackathonV2.html");
  }

  void tearDown() {
    driver.quit();
  }
}
