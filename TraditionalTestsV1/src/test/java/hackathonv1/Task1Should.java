package hackathonv1;

import com.google.gson.JsonElement;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import traditionalv1.utils.HackathonReporter;

public class Task1Should extends TestBase {

  @Parameters({"browser", "width", "height", "device"})
  @Test()
  public void display_filters_across_devices_correctly(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    Set<Map.Entry<String, JsonElement>> filterElements =
        hackathonV1Page.parseJson("src/main/resources/data/filter_dom_ids.json").entrySet();
    for (Map.Entry<String, JsonElement> filterElement : filterElements) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              filterElement.getKey() + " is displayed",
              filterElement.getValue().getAsString(),
              browser,
              width,
              height,
              device,
              driver
                  .findElement(By.id(String.valueOf(filterElement.getValue().getAsString())))
                  .isDisplayed()));
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
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    Set<Map.Entry<String, JsonElement>> footerElements =
        hackathonV1Page.parseJson("src/main/resources/data/footer_dom_ids.json").entrySet();
    for (Map.Entry<String, JsonElement> footerElement : footerElements) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              footerElement.getKey() + " is displayed",
              footerElement.getValue().getAsString(),
              browser,
              width,
              height,
              device,
              driver
                  .findElement(By.id(String.valueOf(footerElement.getValue().getAsString())))
                  .isDisplayed()));
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
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    Set<Map.Entry<String, JsonElement>> headerElements =
        hackathonV1Page.parseJson("src/main/resources/data/header_dom_ids.json").entrySet();
    for (Map.Entry<String, JsonElement> headerElement : headerElements) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              headerElement.getKey() + " is displayed",
              headerElement.getValue().getAsString(),
              browser,
              width,
              height,
              device,
              driver
                  .findElement(By.id(String.valueOf(headerElement.getValue().getAsString())))
                  .isDisplayed()));
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
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    Set<Map.Entry<String, JsonElement>> productElements =
        hackathonV1Page.parseJson("src/main/resources/data/product_dom_ids.json").entrySet();
    for (Map.Entry<String, JsonElement> productElement : productElements) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              productElement.getKey() + " is displayed",
              productElement.getValue().getAsString(),
              browser,
              width,
              height,
              device,
              driver
                  .findElement(By.id(String.valueOf(productElement.getValue().getAsString())))
                  .isDisplayed()));
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
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    Set<Map.Entry<String, JsonElement>> searchElements =
        hackathonV1Page.parseJson("src/main/resources/data/search_dom_ids.json").entrySet();
    for (Map.Entry<String, JsonElement> searchElement : searchElements) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              1,
              searchElement.getKey() + " is displayed",
              searchElement.getValue().getAsString(),
              browser,
              width,
              height,
              device,
              driver
                  .findElement(By.id(String.valueOf(searchElement.getValue().getAsString())))
                  .isDisplayed()));
    }
    softAssertions.assertAll();
  }
}
