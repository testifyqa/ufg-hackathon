package drivers;

import drivers.local.LocalDriverManager;
import drivers.remote.RemoteDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {

  private DriverFactory() {}

  private static final Logger log = LoggerFactory.getLogger(DriverFactory.class.getName());

  public static WebDriver createBrowserInstance(String browser, int width, int height) throws IOException {
    Properties properties = new Properties();
    try {
      InputStream inputStream = new FileInputStream("src/main/resources/config/general.properties");
      properties.load(inputStream);
    } catch (IOException e) {
      log.error(" :: Error reading or loading properties file -> " + e.getMessage());
    }
    Environment environment = Environment.valueOf(properties.getProperty("environment").toUpperCase());
    WebDriver driver;

    switch (environment) {
      case LOCAL -> driver = new LocalDriverManager().createInstance(browser, width, height);
      case GRID -> driver = new RemoteDriverManager().createInstance(browser, width, height);
      default -> throw new IllegalStateException(" :: Unexpected value -> " + environment);
    }
    return driver;
  }
}
