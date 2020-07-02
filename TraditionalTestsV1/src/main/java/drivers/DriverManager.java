package drivers;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

public interface DriverManager {

  WebDriver createInstance(String browser, int width, int height) throws IOException;
}
