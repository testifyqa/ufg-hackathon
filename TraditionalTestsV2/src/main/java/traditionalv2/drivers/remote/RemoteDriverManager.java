package traditionalv2.drivers.remote;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import traditionalv2.drivers.DriverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class RemoteDriverManager implements DriverManager {

  private static final Logger log = LoggerFactory.getLogger(RemoteDriverManager.class.getName());


  @Override
  public WebDriver createInstance(String browser, int width, int height) throws IOException {
    RemoteWebDriver remoteWebDriver = null;

    try {
      InputStream inputStream = new FileInputStream("config/grid.properties");
      Properties properties = new Properties();
      properties.load(inputStream);
      remoteWebDriver = new RemoteWebDriver(
          new URL("http://"
              + properties.getProperty("grid.url")
              + ":"
              + properties.getProperty("grid.port")
              + "/wd/hub"), getCapability(browser));
    } catch (FileNotFoundException | MalformedURLException e) {
      log.error(" :: Grid URL or Browser is invalid, or Grid is unavailable -> " + e.getMessage());
    }
    return remoteWebDriver;
  }

  private static MutableCapabilities getCapability(String browser) {
    MutableCapabilities mutableCapabilities;
    DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());

    switch (driverManagerType) {
      case CHROME -> mutableCapabilities = new ChromeOptions();
      case FIREFOX -> mutableCapabilities = new FirefoxOptions();
      case EDGE -> mutableCapabilities = new EdgeOptions();
      default -> throw new IllegalStateException(" :: Unexpected value -> " + driverManagerType);
    }
    return mutableCapabilities;
  }
}
