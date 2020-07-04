package hackathonv1;

import java.util.Map;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import utils.HackathonReporter;
import widgets.hackathonv1.*;

public class Task1Should extends TestBase {

  @Parameters({"browser", "width", "height", "device"})
  @Test()
  public void display_filters_across_devices_correctly(
      String browser, int width, int height, String device) {
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
      String browser, int width, int height, String device) {
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
      String browser, int width, int height, String device) {
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
      String browser, int width, int height, String device) {
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
      String browser, int width, int height, String device) {
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
      String browser, int width, int height, String device) {
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
}
