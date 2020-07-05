package traditionalv2.drivers;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface DriverManager {

  WebDriver createInstance(String browser, int width, int height) throws IOException;
}
