package hackathonv1;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import traditionalv1.utils.HackathonReporter;

public class Task2Should extends TestBase {

  @Parameters({"browser", "width", "height", "device"})
  @Test
  public void return_black_shoes_when_filtering_for_black_shoes(
      @Optional("chrome") String browser,
      @Optional("1200") int width,
      @Optional("700") int height,
      @Optional("Laptop") String device) {
    hackathonV1Page.filterByColorBlack();
    SoftAssertions softAssertions = new SoftAssertions();
    hackathonReporter = new HackathonReporter();
    softAssertions.assertThat(hackathonV1Page.getListedProducts().size()).isEqualTo(2);
    for (String listedBlackProductElement : hackathonV1Page.getListedBlackProductDomIds()) {
      softAssertions.assertThat(
          hackathonReporter.checkDomIds(
              2,
              "Filter Results - " + listedBlackProductElement + " is displayed",
              listedBlackProductElement,
              browser,
              width,
              height,
              device,
              driver.findElement(By.id(listedBlackProductElement)).isDisplayed()));
    }
    softAssertions.assertAll();
  }
}
