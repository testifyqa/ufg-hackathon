import base.EyesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import traditionalv1.pages.HackathonV1Page;

public class HackathonV1AppShould {

  private WebDriver driver;
  private EyesManager eyesManager;
  private HackathonV1Page hackathonV1Page;

  @BeforeTest
  void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    eyesManager = new EyesManager(driver, "UFG Hackathon");
    eyesManager.setBatchName("UFG Hackathon");
    hackathonV1Page = new HackathonV1Page(driver);
    driver.get("https://demo.applitools.com/gridHackathonV1.html");
  }

  @Test
  public void display_elements_across_devices_correctly() {
    eyesManager.validateWindow("Task 1", "Cross-Device Elements Test");
  }

  @Test
  public void return_black_shoes_when_filtering_for_black_shoes() {
    hackathonV1Page.filterByColorBlack();
    eyesManager.validateRegion("Task 2", "Filter Results", hackathonV1Page.getProductGrid());
  }

  @Test
  public void navigate_to_correct_details_page_when_product_is_selected() {
    hackathonV1Page.clickFirstProduct();
    eyesManager.validateWindow("Task 3", "Product Details test");
  }

  @AfterTest
  void tearDown() {
    eyesManager.abort();
    driver.quit();
  }
}
