import base.EyesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.GridHackathonV1Page;

public class GridHackathonV1Tests {

  private WebDriver driver;
  private EyesManager eyesManager;
  private GridHackathonV1Page hackathonV1Page;

  @BeforeTest
  void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    eyesManager = new EyesManager(driver, "UFG Hackathon");
    eyesManager.setBatchName("UFG Hackathon");
    hackathonV1Page = new GridHackathonV1Page(driver);
    driver.get("https://demo.applitools.com/gridHackathonV1.html");
  }

  @Test
  public void test_ElementsAcrossDevices_DisplayCorrectly() {
    eyesManager.validateWindow("Task 1", "Cross-Device Elements Test");
  }

  @Test
  public void test_FilteringForBlackShoes_ReturnsBlackShoes() {
    hackathonV1Page.filterByColorBlack();
    eyesManager.validateRegion("Task 2", "Filter Results", hackathonV1Page.getProductGrid());
  }

  @Test
  public void test_SelectingFirstBlackShoe_NavigatesToDetailsPage() {
    hackathonV1Page.clickFirstProduct();
    eyesManager.validateWindow("Task 3", "Product Details test");
  }

  @AfterTest
  void tearDown() {
    eyesManager.abort();
    driver.quit();
  }
}
