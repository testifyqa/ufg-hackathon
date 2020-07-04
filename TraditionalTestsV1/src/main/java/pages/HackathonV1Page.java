package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import widgets.hackathonv1.Filters;
import widgets.hackathonv1.Products;

public class HackathonV1Page {

  private final WebDriver driver;
  private final Filters filters;

  private final By listedProducts = By.className("grid_item");
  private final By blackColorFilter = By.id("SPAN__checkmark__107");

  public HackathonV1Page(WebDriver driver) {
    this.driver = driver;
    filters = new Filters();
  }

  public List<WebElement> getListedProducts() {
    return driver.findElements(listedProducts);
  }

  private By getFilterButton() {
    return By.id(filters.filterButton);
  }

  private By getBlackColorFilter() {
    return blackColorFilter;
  }

  private By getOpenFiltersLink() {
    return By.id(filters.openFiltersSidebar);
  }

  private void clickOpenFiltersLink() {
    driver.findElement(getOpenFiltersLink()).click();
  }

  public void filterByColorBlack() {
    if (!driver.findElement(getBlackColorFilter()).isDisplayed()) clickOpenFiltersLink();
    selectBlackColorFilter();
    clickFilterButton();
  }

  public List<String> getListedBlackProducts() {
    Products products = new Products();
    List<String> listedBlackProducts = new ArrayList<>();

    listedBlackProducts.add(products.getProduct1Link());
    listedBlackProducts.add(products.getProduct1Image());
    listedBlackProducts.add(products.getProduct1Name());
    listedBlackProducts.add(products.getProduct1NewPrice());
    listedBlackProducts.add(products.getProduct1OldPrice());
    listedBlackProducts.add(products.getProduct1AddToFavoritesIcon());
    listedBlackProducts.add(products.getProduct1AddToCompareIcon());
    listedBlackProducts.add(products.getProduct1AddToCartIcon());

    listedBlackProducts.add(products.getProduct8Link());
    listedBlackProducts.add(products.getProduct8Image());
    listedBlackProducts.add(products.getProduct8Name());
    listedBlackProducts.add(products.getProduct8NewPrice());
    listedBlackProducts.add(products.getProduct8AddToFavoritesIcon());
    listedBlackProducts.add(products.getProduct8AddToCompareIcon());
    listedBlackProducts.add(products.getProduct8AddToCartIcon());

    return listedBlackProducts;
  }

  private void selectBlackColorFilter() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(getBlackColorFilter()));
    driver.findElement(getBlackColorFilter()).click();
  }

  private void clickFilterButton() {
    driver.findElement(getFilterButton()).click();
  }
}
