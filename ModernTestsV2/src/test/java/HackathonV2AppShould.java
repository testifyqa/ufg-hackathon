import base.EyesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import moderntestsv2.pages.HackathonV2Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HackathonV2AppShould {

  private WebDriver driver;
  private EyesManager eyesManager;
  private HackathonV2Page hackathonV2Page;

  @BeforeTest
  void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    eyesManager = new EyesManager(driver, "UFG Hackathon");
    eyesManager.setBatchName("UFG Hackathon");
    hackathonV2Page = new HackathonV2Page(driver);
    driver.get("https://demo.applitools.com/gridHackathonV2.html");
  }

  @Test
  public void display_elements_across_devices_correctly() {
    eyesManager.validateWindow("Task 1", "Cross-Device Elements Test");
  }

  @Test
  public void return_black_shoes_when_filtering_for_black_shoes() {
    hackathonV2Page.filterByColorBlack();
    eyesManager.validateRegion("Task 2", "Filter Results", hackathonV2Page.getProductGrid());
  }

  @Test
  public void navigate_to_correct_details_page_when_product_is_selected() {
    hackathonV2Page.clickFirstProduct();
    eyesManager.validateWindow("Task 3", "Product Details test");
  }

  @AfterTest
  void tearDown() {
    eyesManager.abort();
    driver.quit();
  }
}
