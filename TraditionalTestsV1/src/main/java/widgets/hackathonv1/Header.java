package widgets.hackathonv1;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Header {

  public String getAppliFashionLogo() {
    return "IMG____9";
  }
  private final String homeNavLink = "A__showsubmen__23";
  private final String menNavLink = "A__showsubmen__25";
  private final String womenNavLink = "A__showsubmen__27";
  private final String runningNavLink = "A__showsubmen__29";
  private final String trainingNavLink = "A__showsubmen__31";

  public HashMap<String, String> getAllNavigationLinks() {
    HashMap<String, String> navigationLinks = new HashMap<>();
    for (Field field : getClass().getDeclaredFields()) {
      try {
        navigationLinks.put(field.getName(), (String) field.get(this));
      } catch (IllegalAccessException e) {
        Logger log = LoggerFactory.getLogger(Header.class.getName());
        log.error(" :: Attempt to access field was illegal -> " + e.getMessage());
      }
    }
    return navigationLinks;
  }
}
