package hackathonv2;

import com.google.gson.JsonElement;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Set;

public class Task3Should {

  private final TestBase testBase = new TestBase();

  @Parameters({"browser", "width", "height"})
  @BeforeClass
  public void beforeClass(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height) {
    testBase.setUp(browser, width, height);
  }

  @Test
  public void navigate_to_correct_details_page_when_product_is_selected(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    SoftAssertions softAssertions = new SoftAssertions();
    testBase.getHackathonV2Page().clickFirstProduct();
    Set<Map.Entry<String, JsonElement>> headerElements =
        testBase
            .getHackathonV2Page()
            .parseJson("src/main/resources/data/header_dom_ids.json")
            .entrySet();
    for (Map.Entry<String, JsonElement> headerElement : headerElements) {
      softAssertions.assertThat(
          testBase
              .getHackathonReporter()
              .checkDomIds(
                  3,
                  "Header - " + headerElement.getKey() + " is displayed",
                  headerElement.getValue().getAsString(),
                  browser,
                  width,
                  height,
                  device,
                  testBase
                      .getDriver()
                      .findElement(By.id(headerElement.getValue().getAsString()))
                      .isDisplayed()));
    }
    Set<Map.Entry<String, JsonElement>> productDetailsElements =
        testBase
            .getHackathonV2Page()
            .parseJson("src/main/resources/data/product_details_dom_ids.json")
            .entrySet();
    for (Map.Entry<String, JsonElement> productDetailsElement : productDetailsElements) {
      softAssertions.assertThat(
          testBase
              .getHackathonReporter()
              .checkDomIds(
                  3,
                  "Product Details - " + productDetailsElement.getKey() + " is displayed",
                  productDetailsElement.getValue().getAsString(),
                  browser,
                  width,
                  height,
                  device,
                  testBase
                      .getDriver()
                      .findElement(By.id(productDetailsElement.getValue().getAsString()))
                      .isDisplayed()));
    }
    softAssertions.assertAll();
  }

  @AfterClass
  public void afterClass() {
    testBase.tearDown();
  }

  @AfterSuite
  public void afterSuite() {
    testBase.getHackathonReporter().sortAlphabetically();
  }
}
