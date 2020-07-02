package drivers.local;

import drivers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import java.lang.reflect.InvocationTargetException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDriverManager implements DriverManager {

  private static final Logger log = LoggerFactory.getLogger(LocalDriverManager.class.getName());

  @Override
  public WebDriver createInstance(String browser, int width, int height) {
    WebDriver driver = null;

    try {
      DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
      Class<?> driverClass = Class.forName(driverManagerType.browserClass());
      WebDriverManager.getInstance(driverManagerType).setup();
      driver = (WebDriver) driverClass.getDeclaredConstructor().newInstance();
      Dimension dimension = new Dimension(width, height);
      driver.manage().window().setSize(dimension);
    } catch (IllegalAccessException
        | InvocationTargetException
        | ClassCastException
        | NoSuchMethodException
        | ClassNotFoundException
        | InstantiationException e) {
      log.error(" :: Error finding or instantiating the class -> " + e.getMessage());
    }
    return driver;
  }
}
