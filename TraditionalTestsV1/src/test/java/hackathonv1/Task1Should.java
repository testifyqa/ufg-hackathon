package hackathonv1;

import com.google.gson.JsonElement;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class Task1Should {

  private final TestBase testBase = new TestBase();

  @Parameters({"browser", "width", "height"})
  @BeforeClass
  public void beforeClass(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height) {
    testBase.setUp(browser, width, height);
  }

  @Parameters({"browser", "width", "height", "device"})
  @Test()
  public void display_filters_across_devices_correctly(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    SoftAssertions softAssertions = new SoftAssertions();
    Set<Map.Entry<String, JsonElement>> filterElements =
        testBase
            .getHackathonV1Page()
            .parseJson("src/main/resources/data/filters_dom_ids.json")
            .entrySet();
    for (Map.Entry<String, JsonElement> filterElement : filterElements) {
      softAssertions.assertThat(
          testBase
              .getHackathonReporter()
              .checkDomIds(
                  1,
                  filterElement.getKey() + " is displayed",
                  filterElement.getValue().getAsString(),
                  browser,
                  width,
                  height,
                  device,
                  testBase
                      .getDriver()
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
    Set<Map.Entry<String, JsonElement>> footerElements =
        testBase
            .getHackathonV1Page()
            .parseJson("src/main/resources/data/footer_dom_ids.json")
            .entrySet();
    for (Map.Entry<String, JsonElement> footerElement : footerElements) {
      softAssertions.assertThat(
          testBase
              .getHackathonReporter()
              .checkDomIds(
                  1,
                  footerElement.getKey() + " is displayed",
                  footerElement.getValue().getAsString(),
                  browser,
                  width,
                  height,
                  device,
                  testBase
                      .getDriver()
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
    Set<Map.Entry<String, JsonElement>> headerElements =
        testBase
            .getHackathonV1Page()
            .parseJson("src/main/resources/data/header_dom_ids.json")
            .entrySet();
    for (Map.Entry<String, JsonElement> headerElement : headerElements) {
      softAssertions.assertThat(
          testBase
              .getHackathonReporter()
              .checkDomIds(
                  1,
                  headerElement.getKey() + " is displayed",
                  headerElement.getValue().getAsString(),
                  browser,
                  width,
                  height,
                  device,
                  testBase
                      .getDriver()
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
    Set<Map.Entry<String, JsonElement>> productElements =
        testBase
            .getHackathonV1Page()
            .parseJson("src/main/resources/data/product_dom_ids.json")
            .entrySet();
    for (Map.Entry<String, JsonElement> productElement : productElements) {
      softAssertions.assertThat(
          testBase
              .getHackathonReporter()
              .checkDomIds(
                  1,
                  productElement.getKey() + " is displayed",
                  productElement.getValue().getAsString(),
                  browser,
                  width,
                  height,
                  device,
                  testBase
                      .getDriver()
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
    Set<Map.Entry<String, JsonElement>> searchElements =
        testBase
            .getHackathonV1Page()
            .parseJson("src/main/resources/data/search_dom_ids.json")
            .entrySet();
    for (Map.Entry<String, JsonElement> searchElement : searchElements) {
      softAssertions.assertThat(
          testBase
              .getHackathonReporter()
              .checkDomIds(
                  1,
                  searchElement.getKey() + " is displayed",
                  searchElement.getValue().getAsString(),
                  browser,
                  width,
                  height,
                  device,
                  testBase
                      .getDriver()
                      .findElement(By.id(String.valueOf(searchElement.getValue().getAsString())))
                      .isDisplayed()));
    }
    softAssertions.assertAll();
  }

  @AfterClass
  public void afterClass() {
    testBase.tearDown();
  }
}
