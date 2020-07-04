package traditionalv1.pages;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HackathonV1Page {

  private final WebDriver driver;
  private final JsonObject blackFilteredProducts;

  private static final Logger log = LoggerFactory.getLogger(HackathonV1Page.class.getName());

  public HackathonV1Page(WebDriver driver) {
    this.driver = driver;
    blackFilteredProducts = parseJson("src/main/resources/data/black_products_dom_ids.json");
  }

  public JsonObject parseJson(String jsonFilePath) {
    Gson gson = new Gson();
    try {
      return gson.fromJson(new FileReader(jsonFilePath), JsonObject.class);
    } catch (FileNotFoundException e) {
      log.error(" :: File '" + jsonFilePath + "' not found -> " + e.getMessage());
      return null;
    }
  }

  public void filterForBlackProducts() {
    JsonObject filters =
        parseJson(System.getProperty("user.dir") + "/src/main/resources/data/filters_dom_ids.json");
    String blackColourFilter = filters.get("colorBlackCheckmark").getAsString();
    if (!driver.findElement(By.id(blackColourFilter)).isDisplayed()) {
      clickElement(filters.get("openFiltersSidebar").getAsString());
    }
    clickElement(filters.get("colorBlackCheckmark").getAsString());
    clickElement(filters.get("filterButton").getAsString());
  }

  private void clickElement(String domId) {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(domId)));
    driver.findElement(By.id(domId)).click();
  }

  public List<WebElement> getListedProducts() {
    return driver.findElements(By.className("grid_item"));
  }

  public List<String> getListedBlackProductDomIds() {
    List<String> listedBlackProductDomIds = new ArrayList<>();
    listedBlackProductDomIds.add(blackFilteredProducts.get("blackProduct1Image").getAsString());
    listedBlackProductDomIds.add(blackFilteredProducts.get("blackProduct1Name").getAsString());
    listedBlackProductDomIds.add(blackFilteredProducts.get("blackProduct1NewPrice").getAsString());
    listedBlackProductDomIds.add(blackFilteredProducts.get("blackProduct1OldPrice").getAsString());
    listedBlackProductDomIds.add(
        blackFilteredProducts.get("blackProduct1AddToFavoritesIcon").getAsString());
    listedBlackProductDomIds.add(
        blackFilteredProducts.get("blackProduct1AddToCompareIcon").getAsString());
    listedBlackProductDomIds.add(
        blackFilteredProducts.get("blackProduct1AddToCartIcon").getAsString());
    listedBlackProductDomIds.add(blackFilteredProducts.get("blackProduct2Image").getAsString());
    listedBlackProductDomIds.add(blackFilteredProducts.get("blackProduct2Name").getAsString());
    listedBlackProductDomIds.add(blackFilteredProducts.get("blackProduct2Price").getAsString());
    listedBlackProductDomIds.add(
        blackFilteredProducts.get("blackProduct2AddToFavoritesIcon").getAsString());
    listedBlackProductDomIds.add(
        blackFilteredProducts.get("blackProduct2AddToCompareIcon").getAsString());
    listedBlackProductDomIds.add(
        blackFilteredProducts.get("blackProduct2AddToCartIcon").getAsString());
    return listedBlackProductDomIds;
  }

  public void clickFirstProduct() {
    JsonObject products =
        parseJson(System.getProperty("user.dir") + "/src/main/resources/data/product_dom_ids.json");
    clickElement(products.get("product1Link").getAsString());
  }
}
