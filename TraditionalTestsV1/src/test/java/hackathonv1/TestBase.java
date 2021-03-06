package hackathonv1;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Optional;
import traditionalv1.drivers.DriverFactory;
import traditionalv1.pages.HackathonV1Page;
import traditionalv1.utils.HackathonReporter;

public class TestBase {

  private static final Logger log = LoggerFactory.getLogger(TestBase.class.getName());

  WebDriver driver;
  HackathonReporter hackathonReporter;
  HackathonV1Page hackathonV1Page;

  public WebDriver getDriver() {
    return driver;
  }

  public HackathonReporter getHackathonReporter() {
    hackathonReporter = new HackathonReporter();
    return hackathonReporter;
  }

  public HackathonV1Page getHackathonV1Page() {
    hackathonV1Page = new HackathonV1Page(driver);
    return hackathonV1Page;
  }

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

  void tearDown() {
    driver.quit();
  }
}
