package base;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import traditionalv1.utils.VisualGridConfig;

public class EyesManager {

  private final Eyes eyes;
  private final WebDriver driver;
  private final String appName;
  private final RectangleSize viewportSize = new RectangleSize(800, 600);

  public EyesManager(WebDriver driver, String appName) {
    this.driver = driver;
    this.appName = appName;

    InputStream inputStream;
    Properties properties = new Properties();
    try {
      inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
      properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

    eyes = new Eyes(new VisualGridRunner(10));
    eyes.setApiKey(properties.getProperty("eyes.api.key"));
    eyes.setConfiguration(VisualGridConfig.getGrid());
  }

  private WebDriver getDriver() {
    return driver;
  }

  private String getAppName() {
    return appName;
  }

  private RectangleSize getViewportSize() {
    return viewportSize;
  }

  public void setBatchName(String batchName) {
    eyes.setBatch(new BatchInfo(batchName));
  }

  public void validateWindow(String testName, String stepName) {
    eyes.open(getDriver(), getAppName(), testName, getViewportSize());
    eyes.check(stepName, Target.window());
    eyes.close();
  }

  public void validateRegion(String testName, String stepName, By locator) {
    eyes.open(getDriver(), getAppName(), testName, getViewportSize());
    eyes.check(stepName, Target.region(locator));
    eyes.close();
  }

  public void abort() {
    eyes.abortIfNotClosed();
  }
}
