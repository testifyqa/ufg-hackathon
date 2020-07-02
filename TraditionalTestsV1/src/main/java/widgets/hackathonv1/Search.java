package widgets.hackathonv1;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Search {

  private final String desktopSearchField = "DIV__customsear__41";
  private final String desktopSearchPlaceholderText = "INPUTtext____42";
  private final String desktopSearchButton = "BUTTONsubmit____43";
  private final String mobileSearchIcon = "A__btnsearchm__59";
  private final String mobileSearchField = "INPUTtext__formcontro__62";
  private final String mobileSearchButton = "INPUTsubmit__btnfullwid__63";

  public HashMap<String, String> getAllSearchElements() {
    HashMap<String, String> searchElements = new HashMap<>();
    for (Field field : getClass().getDeclaredFields()) {
      try {
        searchElements.put(field.getName(), (String) field.get(this));
      } catch (IllegalAccessException e) {
        Logger log = LoggerFactory.getLogger(Search.class.getName());
        log.error(" :: Attempt to access field was illegal -> " + e.getMessage());
      }
    }
    return searchElements;
  }
}
