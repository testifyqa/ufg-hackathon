package traditionalv1.utils;

import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;

public class VisualGridConfig {

  public static Configuration getGrid() {
    Configuration configuration = new Configuration();

    // browsers with laptop viewports
    configuration.addBrowser(1200, 700, BrowserType.CHROME);
    configuration.addBrowser(1200, 700, BrowserType.FIREFOX);
    configuration.addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM);

    // browsers with tablet viewports
    configuration.addBrowser(768, 700, BrowserType.CHROME);
    configuration.addBrowser(768, 700, BrowserType.FIREFOX);
    configuration.addBrowser(768, 700, BrowserType.EDGE_CHROMIUM);

    // mobile emulation devices
    configuration.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

    return configuration;
  }
}
