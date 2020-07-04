package hackathonv1;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class Task2Should {

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
  @Test
  public void return_black_shoes_when_filtering_for_black_shoes(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    SoftAssertions softAssertions = new SoftAssertions();
    testBase.getHackathonV1Page().filterForBlackProducts();
    softAssertions
        .assertThat(testBase.getHackathonV1Page().getListedProducts().size())
        .isEqualTo(2);
    for (String listedBlackProductElement :
        testBase.getHackathonV1Page().getListedBlackProductDomIds()) {
      softAssertions.assertThat(
          testBase
              .getHackathonReporter()
              .checkDomIds(
                  2,
                  "Filter Results - " + listedBlackProductElement + " is displayed",
                  listedBlackProductElement,
                  browser,
                  width,
                  height,
                  device,
                  testBase
                      .getDriver()
                      .findElement(By.id(listedBlackProductElement))
                      .isDisplayed()));
    }
    softAssertions.assertAll();
  }

  @AfterClass
  public void afterClass() {
    testBase.tearDown();
  }
}
