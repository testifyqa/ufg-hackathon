package widgets.hackathonv1;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

  private final String accountIcon = "A__accesslink__56";
  private final String wishlistIcon = "A__wishlist__52";
  private final String cartIcon = "A__cartbt__49";
  private final String cartNotificationIcon = "STRONG____50";

  public HashMap<String, String> getAllUserIcons() {
    HashMap<String, String> userIcons = new HashMap<>();
    for (Field field : getClass().getDeclaredFields()) {
      try {
        userIcons.put(field.getName(), (String) field.get(this));
      } catch (IllegalAccessException e) {
        Logger log = LoggerFactory.getLogger(User.class.getName());
        log.error(" :: Attempt to access field was illegal -> " + e.getMessage());
      }
    }
    return userIcons;
  }
}
