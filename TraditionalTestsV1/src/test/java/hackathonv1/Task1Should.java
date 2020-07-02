package hackathonv1;

import drivers.DriverFactory;
import java.io.IOException;
import java.util.Map;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.HackathonReporter;
import widgets.hackathonv1.*;

public class Task1Should {

  private static final Logger log = LoggerFactory.getLogger(Task1Should.class.getName());

  private WebDriver driver;
  private HackathonReporter hackathonReporter;

  @Parameters({"browser", "width", "height"})
  @BeforeTest
  void setUp(
      @Optional("edge") String browser,
      @Optional("1200") int width,
      @Optional("700") int height) {
    try {
      driver = DriverFactory.createBrowserInstance(browser, width, height);
    } catch (IOException e) {
      log.error(" :: Error creating driver instance -> " + e.getMessage());
    }
    driver.get("https://demo.applitools.com/gridHackathonV1.html");
  }

  @Parameters({"browser", "width", "height", "device"})
  @Test()
  public void display_filters_across_devices_correctly(
      @Optional("edge") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    Filters filters = new Filters();
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    for (Map.Entry<String, String> filterElement : filters.getAllFilters().entrySet()) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              filterElement.getKey() + " is displayed",
              filterElement.getValue(),
              browser,
              width,
              height,
              device,
              driver.findElement(By.id(filterElement.getValue())).isDisplayed()));
    }
    softAssertions.assertAll();
  }

  @Parameters({"browser", "width", "height", "device"})
  @Test()
  public void display_footer_across_devices_correctly(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    Footer footer = new Footer();
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    for (Map.Entry<String, String> footerElement : footer.getAllFooterElements().entrySet()) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              footerElement.getKey() + " is displayed",
              footerElement.getValue(),
              browser,
              width,
              height,
              device,
              driver.findElement(By.id(footerElement.getValue())).isDisplayed()));
    }
    softAssertions.assertAll();
  }

  @Parameters({"browser", "width", "height", "device"})
  @Test()
  public void display_header_items_across_devices_correctly(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    Header header = new Header();
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    for (Map.Entry<String, String> navigationLink : header.getAllNavigationLinks().entrySet()) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              navigationLink.getKey() + " is displayed",
              navigationLink.getValue(),
              browser,
              width,
              height,
              device,
              driver.findElement(By.id(navigationLink.getValue())).isDisplayed()));
    }
    softAssertions.assertAll();
  }

  @Parameters({"browser", "width", "height", "device"})
  @Test()
  public void display_products_across_devices_correctly(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    Products products = new Products();
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    for (Map.Entry<String, String> product : products.getAllProductElements().entrySet()) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              product.getKey() + " is displayed",
              product.getValue(),
              browser,
              width,
              height,
              device,
              driver.findElement(By.id(product.getValue())).isDisplayed()));
    }
    softAssertions.assertAll();
  }

  @Parameters({"browser", "width", "height", "device"})
  @Test()
  public void display_search_across_devices_correctly(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    Search search = new Search();
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    for (Map.Entry<String, String> searchElement : search.getAllSearchElements().entrySet()) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              searchElement.getKey() + " is displayed",
              searchElement.getValue(),
              browser,
              width,
              height,
              device,
              driver.findElement(By.id(searchElement.getValue())).isDisplayed()));
    }
    softAssertions.assertAll();
  }

  @Parameters({"browser", "width", "height", "device"})
  @Test
  public void display_user_icons_across_devices_correctly(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    User user = new User();
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    for (Map.Entry<String, String> userIcon : user.getAllUserIcons().entrySet()) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              userIcon.getKey() + " is displayed",
              userIcon.getValue(),
              browser,
              width,
              height,
              device,
              driver.findElement(By.id(userIcon.getValue())).isDisplayed()));
    }
    softAssertions.assertAll();
  }

  @AfterTest
  void tearDown() {
    driver.quit();
  }
}
