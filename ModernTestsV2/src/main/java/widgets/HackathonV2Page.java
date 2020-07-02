package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HackathonV2Page {

  private final WebDriver driver;

  private final By blackColorFilter = By.id("SPAN__checkmark__107");
  private final By filterButton = By.id("filterBtn");
  private final By productGrid = By.id("product_grid");
  private final By firstProduct = By.id("product_1");
  private final By openFiltersLink = By.id("A__openfilter__206");

  private By getBlackColorFilter() {
    return blackColorFilter;
  }

  private By getFilterButton() {
    return filterButton;
  }

  public By getProductGrid() {
    return productGrid;
  }

  private By getFirstProduct() {
    return firstProduct;
  }

  private By getOpenFiltersLink() {
    return openFiltersLink;
  }

  public HackathonV2Page(WebDriver driver) {
    this.driver = driver;
  }

  public void filterByColorBlack() {
    if (!driver.findElement(getBlackColorFilter()).isDisplayed()) clickOpenFiltersLink();
    selectBlackColorFilter();
    clickFilterButton();
  }

  private void selectBlackColorFilter() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(getBlackColorFilter()));
    driver.findElement(getBlackColorFilter()).click();
  }

  private void clickOpenFiltersLink() {
    driver.findElement(getOpenFiltersLink()).click();
  }

  private void clickFilterButton() {
    driver.findElement(getFilterButton()).click();
  }

  public void clickFirstProduct() {
    driver.findElement(getFirstProduct()).click();
  }
}
