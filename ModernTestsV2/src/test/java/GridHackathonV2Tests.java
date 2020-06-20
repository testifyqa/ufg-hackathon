import base.EyesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GridHackathonV2Page;

public class GridHackathonV2Tests {

  private WebDriver driver;
  private EyesManager eyesManager;
  private GridHackathonV2Page hackathonV2Page;

  @BeforeTest
  void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    eyesManager = new EyesManager(driver, "UFG Hackathon");
    eyesManager.setBatchName("UFG Hackathon");
    hackathonV2Page = new GridHackathonV2Page(driver);
    driver.get("https://demo.applitools.com/gridHackathonV2.html");
  }

  @Test
  public void test_ElementsAcrossDevices_DisplayCorrectly() {
    eyesManager.validateWindow("Task 1", "Cross-Device Elements Test");
  }

  @Test
  public void test_FilteringForBlackShoes_ReturnsBlackShoes() {
    hackathonV2Page.filterByColorBlack();
    eyesManager.validateRegion("Task 2", "Filter Results", hackathonV2Page.getProductGrid());
  }

  @Test
  public void test_SelectingFirstBlackShoe_NavigatesToDetailsPage() {
    hackathonV2Page.clickFirstProduct();
    eyesManager.validateWindow("Task 3", "Product Details test");
  }

  @AfterTest
  void tearDown() {
    eyesManager.abort();
    driver.quit();
  }
}
